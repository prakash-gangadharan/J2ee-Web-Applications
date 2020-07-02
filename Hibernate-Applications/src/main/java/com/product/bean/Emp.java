package com.product.bean;

/**
 *  Employee table 
 *  CREATE TABLE employee(empno number(5), ename varchar2(30), designation varchar2(20), sal number(6));
 */
public class Emp {
	private int empno, sal;
	private String ename, desig;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
}
