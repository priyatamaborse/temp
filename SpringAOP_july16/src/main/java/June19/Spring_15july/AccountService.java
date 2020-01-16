package June19.Spring_15july;

public class AccountService {

	public void getBalance()
	{
		System.out.println("Account Service getBalance=>Begin");
		System.out.println("Account Service getBalance=>Done");
		System.out.println("Account Service getBalance=>end");
	}
	
	public void myDeposit()
	{
		System.out.println("Account Service myDeposite=>Begin");
		System.out.println("Account Service myDeposite=>Done");
		System.out.println("Account Service myDeposite=>End");
	}
	
	public void myWidrow()
	{
		System.out.println("Account Service myWidrow=>Begin");
		
		if(1==1)
		{
			throw new InsufficientFundException();
		}
		System.out.println("Account Service myWidrow=>End");
	}
	
}
