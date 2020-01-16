package June19.Spring_15july;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfiguration {

	
	@Bean
	public SecurityService securityService()
	{
		return new SecurityService();
	}
	
	@Bean
	public TransactionalService transactionalService()
	{
		return new TransactionalService();
	}
	
	@Bean(name = "accountService")
	public AccountService accountService()
	{
		return new AccountService();
	}
	
	@Bean(name = "customerService")
	public CustomerService customerService()
	{
		return new CustomerServiceImpl();
	}
	
	@Bean
	public LogService logService()
	{
		return new LogService();
	}
}
