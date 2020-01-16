package com.test;

import java.util.Arrays;
import java.util.stream.Stream;
@FunctionalInterface
interface sayable {
	void say();
}


public class ParallelSortDemo {

	// ------------------- //parallelSort//
	/*
	 * public static void main(String[] args) {
	 * 
	 * int[] arrInt={10,2,12,1,1,35,91}; long sTime = System.currentTimeMillis();
	 * Arrays.sort(arrInt); long eTime = System.currentTimeMillis();
	 * System.out.println("Sequential Sort Time Taken:"+ (eTime - sTime));
	 * 
	 * 
	 * int[] arrInt = {22, 89, 1, 32, 19, 5}; long sTime =
	 * System.currentTimeMillis(); Arrays.parallelSort(arrInt); long eTime =
	 * System.currentTimeMillis(); System.out.println("Parallel Sort Time Taken:" +
	 * (eTime - sTime)); Arrays.stream(arrInt).forEach(x -> System.out.println(" " +
	 * x)); Arrays.parallelSort(arrInt, 1,2); Arrays.stream(arrInt).forEach(x ->
	 * System.out.println(" --" + x)); }
	 */


	public static void adding(int a,int b){  
        System.out.println("Hello, this is non-static method."+a+b);  
    }  
	public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        sayable sayable = ParallelSortDemo::saySomething;  
        // Calling interface method  
        sayable.say();
        Stream.of("A","B").forEach(System.out::println);
        
        ParallelSortDemo dem=new ParallelSortDemo();
        //sayable saya=dem::adding();
        
    }  
}  

