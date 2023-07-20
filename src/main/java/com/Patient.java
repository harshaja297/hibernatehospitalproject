package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "patients")
public class Patient {
	
	String pname;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int pid;

	private String city;

	private long ppno;
	private String illness;

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	Patient(){
		
	}
	
	Patient(String n , String c , long pn){
		this.setPname(n);
		setCity(c);
		setPpno(pn);
		
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPpno() {
		return ppno;
	}
	public void setPpno(long ppno) {
		this.ppno = ppno;
	}

	@Override
	public String toString() {
		return "Patient [pname=" + pname + ", pid=" + pid + ", city=" + city + ", ppno=" + ppno + ", illness=" + illness
				+ "]";
	}
	

	
}
