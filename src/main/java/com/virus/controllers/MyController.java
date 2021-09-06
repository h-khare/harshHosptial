package com.virus.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virus.Model.BedsProvide;
import com.virus.Model.User;
import com.virus.service.AvailableBedsServie;

@Controller
public class MyController {
	
	@Autowired
	AvailableBedsServie availableBedsServie;
	
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("locationStats",availableBedsServie.getAllstarts());
		return "home";
	}
	
	@GetMapping("/checks")
	public String view()
	{
		System.out.println("ACHA");
		return "bedchecker";
	}
	
	@RequestMapping(value="checker", method = RequestMethod.POST)
	public String bedChecker(@ModelAttribute User user,HttpServletResponse response,Model model) throws IOException
	{
		List<BedsProvide> allbeds=this.availableBedsServie.getAllstarts();
		model.addAttribute("locationStats",availableBedsServie.getAllstarts());
		
		
		String user_name=user.getName();
		String user_city=user.getCity();
		
		for(BedsProvide bd:allbeds)
		{
			if(bd.getCity().equals(user_city))
			{
				model.addAttribute("bedsquantity", bd);
				return "bed";
			}
		}
		
		System.out.println(user);
		return "home";
		
	}
	@RequestMapping("/greet")
	public String greet()
	{
		return "index";
	}

}
