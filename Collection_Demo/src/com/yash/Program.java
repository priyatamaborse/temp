package com.yash;

import java.util.ArrayList;
import java.util.Iterator;

public class Program {

	public static void main(String[] args) 
	{
		ArrayList<Integer> arrayList=new ArrayList<>();
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(7);
		arrayList.add(3);
		arrayList.add(10);
		arrayList.add(23);
		Iterator itr=arrayList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			
		}

	}

}
