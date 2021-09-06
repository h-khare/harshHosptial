package com.virus.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.virus.Model.BedsProvide;

@Service
public class AvailableBedsServie {
	
	
	public String BEDS_DATA="https://raw.githubusercontent.com/vikru10/Medical/main/Medical/medical-colleges.csv";
	private List<BedsProvide> allstarts=new ArrayList<>();
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchValueData() throws IOException, InterruptedException
	{
		List<BedsProvide> newStarts=new ArrayList<>();
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create(BEDS_DATA)).build();
		
		HttpResponse<String> httpsResponse=client.send(request, HttpResponse.BodyHandlers.ofString());
		
//		System.out.println(httpsResponse.body());
		StringReader csvbodyReader=new StringReader(httpsResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvbodyReader);
		for (CSVRecord record : records) {
			BedsProvide beds=new BedsProvide(); 
			beds.setBeds(Integer.parseInt(record.get("hospitalBeds")));
			beds.setHospital_name(record.get("name"));
			beds.setCity(record.get("city"));
			beds.setState(record.get("state"));
//			System.out.println(beds);
			newStarts.add(beds);
		}
		this.allstarts=newStarts;
		
	}
	public String getBEDS_DATA() {
		return BEDS_DATA;
	}
	public void setBEDS_DATA(String bEDS_DATA) {
		BEDS_DATA = bEDS_DATA;
	}
	public List<BedsProvide> getAllstarts() {
		return allstarts;
	}
	public void setAllstarts(List<BedsProvide> allstarts) {
		this.allstarts = allstarts;
	}

}
