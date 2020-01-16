package June19.Spring_15july;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfiguration.class);
		
		CustomerService customerService=(CustomerService) ctx.getBean("customerService");
		customerService.addCustomer();
		customerService.updateCustomer();
		ctx.close();
		
	}
}
