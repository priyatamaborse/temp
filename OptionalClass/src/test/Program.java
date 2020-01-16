package test;

import java.util.*;


public class Program 
{
	public static void main(String[] args) {
	

		try 
		{
			String []arr=new String[10];
			String lowerCase=arr[7].toLowerCase();
		}
		catch (NullPointerException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		String []arr1=new String[10];
		Optional<String> stri=Optional.ofNullable(arr1[5]);
		if(stri.isPresent())
		{
			//String lower=stri.toLowerCase();
		}
		else
			System.out.println("not present");
		
	}

}
