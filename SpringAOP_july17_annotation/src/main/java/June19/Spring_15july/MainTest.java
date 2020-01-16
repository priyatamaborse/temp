package June19.Spring_15july;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		
		EmployeeService employeeService=(EmployeeService) ctx.getBean("employeeService");
		employeeService.createEmployee(new EmployeeDTO());
		//employeeService.updateEmployee(new EmployeeDTO());
		//employeeService.deleteEmployee(1);
		ctx.close();
		
	}
}
