package test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface testLambda
{
	public void test();
}
public class Program 
{
	int x=10;
	public void test()
	{
		int y=20;
		// y=10; compile time error as local variable become final because of lambda expression
		System.out.println("X "+x);
		System.out.println("Y "+y);
		testLambda l=()->
		{
			System.out.println("X "+x);
			System.out.println("Y "+y);
			
		};
		
		l.test();
	}
	
	
	
	public static void main(String[] args) {

		//create stream object where c in below code can be any collection
		List c=new ArrayList<>();
		Stream s=c.stream();
		
		
		
		Program p=new Program();
		p.test();
		
	
		//1-------
		Stream<Integer> stream=Stream.of(1,2,3,4,5,6);
		stream.forEach(System.out::println);
		
		
		//2
		Stream<String> stream2=Stream.of(new String[] {"abc","pqr","ad"});
		stream2.forEach(x->System.out.println(" "+x));

		//3
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			list.add(i);
		}
		Stream<Integer> stream3=list.stream();
		long count=stream3.count();
		System.out.println("Count  "+count);
	
		
		//4
		
		Stream<Date> stream4=Stream.generate(()->{return new Date();}).limit(4);
		stream4.forEach(System.out::println);
		//5
		Stream<Character>charStream ="abcd".chars().mapToObj(x->(char)x);
		charStream.forEach(x->System.out.println("x ->" +x));
	
		
		//map Method
		 List<Integer> num = Arrays.asList(1,2,3,4,5);
	        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
	        System.out.println(collect1); //[2, 4, 6, 8, 10]
		List<Integer> arr = Arrays.asList(1,2,3);
		List<Integer> square=
		arr.stream().map(x->x*x).collect(Collectors.toList());
		
		//filter method
		List<Integer> list2=Arrays.asList(1,2,3,5,4);
		list2.stream().filter(x->x%2==0).forEach(System.out::println);
		
		
		//sorted() Method for Natural order of sorting
		List<String> list3=Arrays.asList("sfd","ytr","sad","rtf");
		list3.stream().sorted().forEach(System.out::println);
		
		//sorted(Comparator c) Method for Customized way of sorting(Minus - for desending order)
		List<String> listnew=Arrays.asList("sfd","ytr","sad","rtf");
		listnew.stream().sorted((i1,i2)->-i1.compareTo(i2)).forEach(System.out::println);
		//or make arrguments reverse
		listnew.stream().sorted((i1,i2)->i2.compareTo(i1)).forEach(System.out::println);
		
		//collect method
		List<Integer> l1=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			l1.add(i);
		}
		List<Integer> evenList=l1.stream().filter(x->x%2==0).collect(Collectors.toList());
		evenList.forEach(System.out::println);
		
		//reduce
		List<Integer> list4=Arrays.asList(10,20,30,40,55);
		int sum=list4.stream().filter(x->x%2==0).reduce(0,(val,i)->val+i);
		System.out.println("sum  ="+sum);
		

		List<String> list5=Arrays.asList("abc","sd","sdf");
		Optional<String> stOptional=list5.stream().filter(x->!x.equals("abc")).reduce((val,i)->val+i);
		System.out.println("sum  ="+stOptional.toString());
		
		//Supplier interface
		//Allow to reuse of Stream
		String[] arr1= {"a","b","c"};
		Supplier<Stream<String>> supplier=()->Stream.of(arr1);
		supplier.get().forEach(System.out::println);
		long count1=supplier.get().filter(x->x.equals("a")).count();
		System.out.println("Count=>"+count1);
		
		//Parallel Stream
		List<Integer> list6=new ArrayList<>();
		for(int i=0;i<5;i++)
		{
			list6.add(i);
		}
		long count3=list6.parallelStream().filter(x->x%2==0).count();
		System.out.println("couunt="+count3);
		
		//CroneUnit
		LocalDate date=LocalDate.now();
		LocalDate nextMonth=date.plus(1, ChronoUnit.MONTHS);
		System.out.println(" "+nextMonth);
		
		
	}
	
	
}
