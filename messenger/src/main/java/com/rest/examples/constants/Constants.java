package com.rest.examples.constants;

import java.util.HashMap;
import java.util.Map;

import com.rest.examples.bean.Employee;


public class Constants {
	 public static Map<String, Employee> employees = new HashMap<String, Employee>();
	
	static{
		
        Employee employee1 = new Employee();
        employee1.setEmployeeId("11111");
        employee1.setEmployeeName("Dineh Rajput");
        employee1.setJobType("Sr.Software Engineer");
        employee1.setSalary(70000l);
        employee1.setAddress("Noida");
        employees.put(employee1.getEmployeeId(), employee1);
        
        Employee employee2 = new Employee();
        employee2.setEmployeeId("22222");
        employee2.setEmployeeName("Abhishek");
        employee2.setJobType("Marketing");
        employee2.setSalary(50000l);
        employee2.setAddress("New Delhi");
        employees.put(employee2.getEmployeeId(), employee2);
		
	}

}
