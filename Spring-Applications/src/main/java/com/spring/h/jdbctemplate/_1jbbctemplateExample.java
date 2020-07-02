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

public class _1jbbctemplateExample { 

    public static void main(String args[]) {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/spring/h/jdbctemplate/config/spring-01.xml");

        JdbcTemplate jdbcTemplate= (JdbcTemplate)ctx.getBean("jdbcTemplate");
        System.out.println(" jdbcTemplate Object : "+jdbcTemplate);
        
        /* create table using execute*/       
//        jdbcTemplate.execute("CREATE TABLE sptest(id SERIAL PRIMARY KEY NOT NULL,type character varying(20) NOT NULL, path text)");
        
		Object o1 = jdbcTemplate.queryForObject("SELECT NOW() ", Date.class);
		Object o2 = jdbcTemplate.queryForObject("SELECT id FROM sptest LIMIT 1", Integer.class);
		Object o3 = jdbcTemplate.queryForObject("SELECT type FROM sptest LIMIT 1", String.class);
		
		System.out.println((Date)o1);
		System.out.println(o2);
		System.out.println(o3);

/*		
		List list = jdbcTemplate.queryForList("SELECT * FROM elk_loglist");

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
*/
		int rows;
/*		
		// Update
		String query = "INSERT INTO sptest (type,path) VALUES ('type1','path1'), ('type2','path2')";
		rows = jdbcTemplate.update(query);
		System.out.println(rows + " : were inserted");
*/
		Object values[] = { "wsite","java4s"};
		System.out.println(" size : "+values.length);
		rows = jdbcTemplate.update("INSERT INTO sptest (type,path) VALUES (?,?)", values);
		
		System.out.println(rows + " : were inserted");
		
		// Close Spring Context
		ctx.close();

		System.out.println("SUCCESS");
    }
}