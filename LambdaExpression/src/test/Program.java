package test;

import java.util.*;


public class Program 
{
	public static void main(String[] args) {
	

		Thread t=new Thread(
				()->{
					for(int i=0;i<5;i++)
					{
						System.out.println(" "+i);
					}
				}
				);
		t.start();
	}

}
