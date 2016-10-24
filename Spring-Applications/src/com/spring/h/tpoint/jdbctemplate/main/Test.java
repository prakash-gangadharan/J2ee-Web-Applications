package com.spring.h.tpoint.jdbctemplate.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.h.tpoint.jdbctemplate.bean.Employee;
import com.spring.h.tpoint.jdbctemplate.dao.EmployeeDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext appilcationcontext = 
				new ClassPathXmlApplicationContext("com/spring/h/tpoint/jdbctemplate/config/applicationContext.xml");
		
		System.out.println(appilcationcontext);
		
		int status = 0, deleteStatus = 0;
		
		EmployeeDao dao =  (EmployeeDao) appilcationcontext.getBean("edao");
		
		//----------------------------------------//
		dao.saveEmployee(new Employee(102, "prakash", 35000));
		
		//----------------------------------------//
		
		//status = dao.updateEmployee(new Employee(103, "Sonoo", 15000));
		System.out.println(status + " rows updated");
		
		Employee e = new Employee();
		e.setId(102);
		
		//deleteStatus = dao.deleteEmployee(e);
		System.out.println(deleteStatus + " rows deleted");
		
		//----------------------------------------//
		Boolean isUpdated = dao.saveEmployeeByPreparedStatement(new Employee(104, "prakash", 16000));
		
		System.out.println(isUpdated);
		
		
		dao.show();

	}

}
