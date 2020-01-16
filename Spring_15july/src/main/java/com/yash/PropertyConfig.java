package com.yash;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Configuration
public class PropertyConfig {
	
	@Bean
	public Student student(){
		Student student = new Student();
		student.setStudentName("Megha");
		student.setPhone(12355l);
		return student;
	}
	

	@Bean
	public String sid() {
		return "E10-123";
	}
	@Bean
	public String fee() {
		return "10000,12454";
	}

	@Bean
	public String emails() {
		return "asda@yash.com,asda@fddf";
	}
	
	@Bean
	public List<Long> phones(){
		List<Long> list = new ArrayList<>();
		list.add(24545L);
		list.add(2453L);
		list.add(24545L);
		return list;
	}
	
	@InitBinder
	public void initBinderAll(WebDataBinder webDataBinder){
		System.out.println("In Initbinder");
		webDataBinder.registerCustomEditor(Fee.class,new FeeEditor());
		webDataBinder.registerCustomEditor(StudentId.class,new StudentIdEditor());
	}
}
