package June19.Spring_15july;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingService {

	@Before("execution(* June19.Spring_15july.EmployeeService*.*(..))")
	public void initEmployee()
	{
		System.out.println("LoggingService initEmployee()");
	}
	
	@Before("execution(* June19.Spring_15july.EmployeeService.delete*(..))")
	public void beforeDeleteEmployee()
	{
		System.out.println("LoggingService beforeDeleteEmployee()");
	}
	
	@AfterReturning("execution(* June19.Spring_15july.EmployeeService.get*(..))")
	public void logAfterGetEmployee()
	{
		System.out.println("LoggingService logAfterGetEmployee()");
	}
	
	@After("execution(* June19.Spring_15july.EmployeeService.create*(..))")
	public void logAfterCreateEmployee()
	{
		System.out.println("LoggingService logAfterCreateEmployee()");
	}
	
	@Around("execution(* June19.Spring_15july.EmployeeService.update*(..))")
	public void updateEmployeeSuccessfully()
	{
		System.out.println("LoggingService(@around) updateEmployeeSuccessfully()");
	}
	
	@AfterThrowing("execution(* June19.Spring_15july.EmployeeService.getEmployeeById*(..))")
	public void unableToGetEmployee()
	{
		System.out.println("LoggingService unableToGetEmployee()");
	}
	
}
