package June19.Spring_15july;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfiguration {
	
	@Bean
	public EmployeeService employeeService()
	{
		return new EmployeeServiceImpl();
	}
	
	@Bean
	public LoggingService loggingService()
	{
		return new LoggingService();
	}
}
