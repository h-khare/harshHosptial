package com.virus.Model;

public class BedsProvide {
	
	private int beds;
	private String hospital_name;
	private String city;
	private String state;
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "BedsProvide [beds=" + beds + ", hospital_name=" + hospital_name + ", city=" + city + ", state=" + state
				+ "]";
	}
	
	

}
