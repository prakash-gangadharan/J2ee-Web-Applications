package com.spring.h.tpoint.jdbctemplate.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.h.tpoint.jdbctemplate.bean.Employee;

public class EmployeeDao {
	private JdbcTemplate jdbctemplate;
	
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	/**
	 * JdbcTemplate's update method
	 * 
	 * @param employee
	 * @return
	 */
	public int saveEmployee(Employee employee){
		String query = null;
		try {
			query = "INSERT INTO employee VALUES("+employee.getId()+", '"+employee.getName()+"', "+employee.getSalary()+")";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdbctemplate.update(query);
	}
	
	
	public int updateEmployee(Employee employee){
		String query = null;
		try {
			query = "UPDATE employee SET "+" name='"+employee.getName()+"', salary="+employee.getSalary()+" WHERE id ="+employee.getId()+"";
			System.out.println(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdbctemplate.update(query);
	}
	
	public int deleteEmployee(Employee employee){
		String query = null;
		try {
			query="DELETE FROM employee WHERE id='"+employee.getId()+"' ";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdbctemplate.update(query);
		
	}
	
	public Boolean saveEmployeeByPreparedStatement(final Employee e){
		
		 String query="INSERT INTO employee VALUES(?,?,?)";  
		
		return jdbctemplate.execute(query, new PreparedStatementCallback<Boolean>(){

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
			    ps.setInt(1, e.getId());
			    ps.setString(2, e.getName());
			    ps.setFloat(3, e.getSalary());
				
				return ps.execute();
			}
			});
	}
	
	public void show(){
		
		List<Employee> lst = jdbctemplate.query("select * from employee", new ResultSetExtractor<List<Employee>>(){

			@Override
			public List<Employee> extractData(ResultSet rst) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				System.out.println(rst);
				
				List<Employee> lst = new ArrayList<Employee>();
				while(rst.next()){
					Employee emp = new Employee();
					
					emp.setId(rst.getInt(1));
					emp.setName(rst.getString(2));
					emp.setSalary(rst.getInt(3));
					
					lst.add(emp);
				}
				return lst;
			}
		});
		
		System.out.println(lst);
	}
}
