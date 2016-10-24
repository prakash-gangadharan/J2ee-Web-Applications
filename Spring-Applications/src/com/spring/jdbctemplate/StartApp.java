package com.spring.jdbctemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Andreas Koehn on 27.05.2015.
 */
public class StartApp {

    public static void main(String args[]) {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/jdbctemplate/config/spring.xml");

        //Get the EmployeeDAO Bean
        // Type safety variant of getbean
        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);

        //Get All
        List<PersonPOJO> personList = personDAO.getAll();
        System.out.println(personList);

        //Close Spring Context
        ctx.close();
    }
}

/*
 * CREATE TABLE test_table(NAME character varying(20),SURNAME character varying(20), AGE INT);
 * INSERT INTO test_table VALUES ('vanitha', 'ganga', 19) , ('vanitha', 'ganga', 19);
 * 
 */
