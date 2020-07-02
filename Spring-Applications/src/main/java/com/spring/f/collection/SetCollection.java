package com.spring.f.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetCollection {
	private Set students;
	private List servers;
	private Map modules;
	

	public void setModules(Map modules) {
		this.modules = modules;
	}

	public void setServers(List servers) {
		this.servers = servers;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public void show(){
		System.out.println(" > show students....");
		System.out.println(students);
	}
	
	public void showServers(){
		System.out.println(" > show servers....");
		System.out.println(servers);
	}
	
	public void showModules(){
		System.out.println(" > show modules....");
		System.out.println(modules);
	}
}
