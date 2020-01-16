package com.yash;


interface addable
{
	public void add();
}

class derived implements addable
{

	@Override
	public void add() {
		System.out.println("in add");
		
	}
	public void sub() {
		System.out.println("in sub");
		
	}
}
public class Program {

	public static void main(String[] args) 
	{	
		derived d=new derived();
		d.add();
		d.sub();
		addable a=new derived();
		a.add();
		//a.sub(); compile time error
 	}

}
