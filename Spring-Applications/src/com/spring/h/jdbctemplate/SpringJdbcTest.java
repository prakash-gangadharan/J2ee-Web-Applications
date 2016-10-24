package com.spring.h.jdbctemplate;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class SpringJdbcTest {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
/*
 * create table using execute 
 */
	public void methodCreateTable() {

		jt.execute("CREATE TABLE sptest(id SERIAL PRIMARY KEY NOT NULL,type character varying(20) NOT NULL, path text)");

		System.out.println("SUCCESS");
	}

/*
 * queryForObject 
 */
	public void methodQueryForObject() {
		Object o1 = jt.queryForObject("SELECT NOW() ", Date.class);
		Object o2 = jt.queryForObject("SELECT id FROM sptest LIMIT 1", Integer.class);
		Object o3 = jt.queryForObject("SELECT type FROM sptest LIMIT 1", String.class);

		System.out.println((Date) o1);
		System.out.println(o2);
		System.out.println(o3);
	}
	
/*
 * queryForList
 */
	public void methodQueryForList() {
		List list = jt.queryForList("SELECT * FROM elk_loglist");

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

/*
 * update
 */
	public void methodUpdate() {
		int rows;

		String query = "INSERT INTO sptest (type,path) VALUES ('type1','path1'), ('type2','path2')";
		rows = jt.update(query);
		System.out.println(rows + " : were inserted");
	}
	
/*
 * update
 */
	public void methodInsert() {
		int rows;

		Object values[] = { "wsite", "java4s" };
		System.out.println(" size : " + values.length);
		rows = jt.update("INSERT INTO sptest (type,path) VALUES (?,?)", values);

		System.out.println(rows + " : were inserted");
	}

/*
 * 	PreparedStatementCallback
 */
	public void methodPreparedStatementCallback(){
		String query = "INSERT INTO sptest (type,path) VALUES (?,?)";
		
		Boolean bflag = jt.execute(query, new PreparedStatementCallback<Boolean>(){

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setString(1, "noninvasive");
				ps.setString(2, "Spring");
				return ps.execute();
			}});
		
		System.out.println(bflag+" SUCCESS");
	}

/*
 *  RowMapper
 */
	public void methodRowMapper(){
		String query = "SELECT * FROM elk_loglist";
		List<Elk> list = jt.query(query, new RowMapper<Elk>(){
		
			@Override
			public Elk mapRow(ResultSet rs, int rownumber) throws SQLException {
				//System.out.println(rownumber);
				Elk elk = new Elk();
				elk.setElk_log_id(rs.getInt("elk_log_id"));
				elk.setLog_type(rs.getString("log_type"));
				return elk;
			}});
		
		System.out.println(list);
	}
/*
 *  ResultSetExtractor
 */
	public void methodResultSetExtractor(){
		String query = "SELECT * FROM elk_loglist";	
		List<Elk> list = jt.query(query, new ResultSetExtractor<List<Elk>>(){

			@Override
			public List<Elk> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				List<Elk> list=new ArrayList<Elk>();
				
				while(rs.next()){
					Elk elk = new Elk();
					elk.setElk_log_id(rs.getInt("elk_log_id"));
					elk.setLog_type(rs.getString("log_type"));
					list.add(elk);
				}
				return list;
			}});
		
		System.out.println(list);
	}
}
