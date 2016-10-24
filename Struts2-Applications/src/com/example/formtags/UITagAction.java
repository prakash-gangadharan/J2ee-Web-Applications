package com.example.formtags;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class UITagAction extends ActionSupport{
	private String name;
	private String address;
	private String password;
	private String gender;
	private String message;
	private List<String> courseType;
	private String courseName;
	
	private List<String> locations;
	private String locationName;
	
	private List<String> searchEngine;

	private String yourSearchEngine;
	
	public UITagAction(){
		
		searchEngine = new ArrayList<String>();
		searchEngine.add("google.com");
		searchEngine.add("bing.com");
		searchEngine.add("yahoo.com");
		searchEngine.add("baidu.com");
		
		locations = new ArrayList<String>();
		locations.add("Chennai");
		locations.add("Bangalore");
		locations.add("Hyderabad");
		locations.add("Pune");
		
		courseType = new ArrayList<String>();
		courseType.add("ME");
		courseType.add("BE");
		courseType.add("BBA");
		courseType.add("MBA");
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<String> getSearchEngine() {
		return searchEngine;
	}
	public void setSearchEngine(List<String> searchEngine) {
		this.searchEngine = searchEngine;
	}

	public String getYourSearchEngine() {
		return yourSearchEngine;
	}
	public void setYourSearchEngine(String yourSearchEngine) {
		this.yourSearchEngine = yourSearchEngine;
	}

	public List<String> getCourseType() {
		return courseType;
	}
	public void setCourseType(List<String> courseType) {
		this.courseType = courseType;
	}
	
	public String[] getDefaultLocation(){
		return new String[]{"Chennai","Bangalore","Hyderabad"};		
	}
	
	public List<String> getLocations() {
		return locations;
	}
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String execute(){
		return SUCCESS;
		
	}
}
