package com.springmvc.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.example.beans.Emp;

public class EmpDao {
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Emp emp){
		
		String sql = "INSERT INTO Emp99(name,salary,designation) VALUES ('"+emp.getName()+"',"+emp.getSalary()+",'"+emp.getDesignation()+"')";
		
		template.update(sql);
		
		return 0;
		
	}
}
