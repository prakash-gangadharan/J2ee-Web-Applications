package com.spring.h.jdbctemplate;

public class Elk {
	private int elk_log_id;
	private String log_type;

	public int getElk_log_id() {
		return elk_log_id;
	}

	public String getLog_type() {
		return log_type;
	}

	public void setElk_log_id(int elk_log_id) {
		this.elk_log_id = elk_log_id;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	
	public String toString(){
		return elk_log_id+"-"+log_type;
		
	}
}
