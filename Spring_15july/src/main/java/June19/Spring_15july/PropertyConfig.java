package June19.Spring_15july;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Configuration
public class PropertyConfig {

	@Bean
	public Student student()
	{
		Student student = new Student();
		student.setStudentName("priya");
		student.setPhone(12355L);
		return student;
	}

	@Bean(name="sid")
	public String studentId()
	{
		return "E10-122";
	}
	
	@Bean
	public String emails()
	{
		return "pp@gamil.com,aa@yash.com,bb@yash.com";
	}
	
	@Bean
	public List<Long> phones()
	{
		List<Long> phones = new ArrayList<Long>();
		phones.add(11L);
		phones.add(22L);
		phones.add(33L);
		return phones;
	}
	
	@InitBinder
	public void initIniderAll(WebDataBinder webDataBinder)
	{
		webDataBinder.registerCustomEditor(Fee.class, new FeeEditor());
		webDataBinder.registerCustomEditor(StudentID.class, new StudentIdEditor());
		webDataBinder.registerCustomEditor(List.class, new ListEditor());
	}
	
}
