package com.yash;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */

//@SpringBootApplication
public class SpringBootApp 
{
    public static void main( String[] args )
    {
        
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
       
       System.out.println("Spring container is Ready");
       
       Student student = (Student) ctx.getBean("student");
       System.out.println(student.getStudentName());
       System.out.println(student.getFee());
       
       ctx.close();
    	
    	/*Integer [] arr = {1,2,3};
    	List<Integer> list = new ArrayList<>();
    	list = Arrays.asList(arr);
    	list.add(4);
    	System.out.println(list.size());*/
    	
    }
}
