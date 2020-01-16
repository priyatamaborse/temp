package June19.Spring_15july;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransactionalService {

	@Pointcut(value="execution(* June19.Spring_15july.AccountService.my*(..))")
	public void method1()
	{
		
	}
	
	@Pointcut(value="execution(* June19.Spring_15july.CustomerService.up*(..))")
	public void method2()
	{
		
	}
	
	@Before(value="method1()")
	public void verifyUser()
	{
		System.out.println("TransactionService verifyUser");
	}
	
	@AfterReturning("method1()")
	public void commit()
	{
		System.out.println("TransactionService commit()");
	}
	
	@AfterThrowing("method1()")
	public void rollback()
	{
		System.out.println("TransactionService rollback()");
	}
}
