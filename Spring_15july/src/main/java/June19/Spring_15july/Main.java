package June19.Spring_15july;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(PropertyConfig.class);
		Student student = (Student)ctx.getBean("student");
		System.out.println(student.getStudentName());
		ctx.close();
		
		/*Integer [] arr= {1,2,3};
		List<Integer> list = new ArrayList<Integer>();
		
		list = Arrays.asList(arr);
		list.add(4); //once we define array we can not modify
		System.out.println(list.size());
		*/

	}

}
