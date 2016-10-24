package com.javatpoint;
import java.sql.*;
public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ss_velocity","postgres","postgres");
	}catch(Exception e){System.out.println(e);}
	return con;
    }
}
