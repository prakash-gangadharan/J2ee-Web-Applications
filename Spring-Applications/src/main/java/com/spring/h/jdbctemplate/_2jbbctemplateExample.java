package com.spring.h.jdbctemplate;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *  jbbctemplate Example
 *                                  Table "public.sptest"
 Column |         Type          |                      Modifiers                      
--------+-----------------------+-----------------------------------------------------
 id     | integer               | not null default nextval('sptest_id_seq'::regclass)
 type   | character varying(20) | not null
 path   | text                  | 
Indexes:
    "sptest_pkey" PRIMARY KEY, btree (id)
 */
 
public class _2jbbctemplateExample { 

    public static void main(String args[]) {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(""
        		+ "com/spring/h/jdbctemplate/config/spring-02.xml");

        SpringJdbcTest springJdbcTest= ctx.getBean("springJdbcTest",SpringJdbcTest.class);
        System.out.println(" SpringJdbcTest Object : "+springJdbcTest);
        
        //springJdbcTest.methodCreateTable(); // create table
        
 /*
   		springJdbcTest.methodUpdate(); // update
        
        springJdbcTest.methodInsert(); //insert
        
        springJdbcTest.methodQueryForObject();
        
        springJdbcTest.methodQueryForList();
        
        springJdbcTest.methodPreparedStatementCallback();
*/
        springJdbcTest.methodResultSetExtractor();
 
        springJdbcTest.methodRowMapper();
        
    }
}