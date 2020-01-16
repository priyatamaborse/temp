package test;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		Integer arr[]= {10,20,30,40};
		ArrayList<Integer> list=new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.forEach(System.out::println);

	}

}
