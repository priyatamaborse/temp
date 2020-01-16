package com.yash;

import java.util.List;

import javax.annotation.Resource;

public class Student {

	@Resource
	private StudentId sid;
	
	private String studentName;
	
	private Long phone;
	
	@Resource
	private Fee fee;
	
	private List<String> emails;
	
	private List<Long> phones;

	public StudentId getSid() {
		return sid;
	}

	public void setSid(StudentId sid) {
		this.sid = sid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Long> getPhones() {
		return phones;
	}

	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}
}
