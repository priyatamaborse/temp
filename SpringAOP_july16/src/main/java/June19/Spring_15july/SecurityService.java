package June19.Spring_15july;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityService {

	@Pointcut(value="execution(* June19.Spring_15july.AccountService.my*(..))")
	public void method1()
	{
		
	}
	
	@Pointcut(value="execution(* June19.Spring_15july.CustomerService.up*(..))")
	public void method2()
	{
		
	}
	
	@Before(value="method1() or method2()")
	public void verifyUser()
	{
		System.out.println("SecurityService verifyUser");
	}
}
