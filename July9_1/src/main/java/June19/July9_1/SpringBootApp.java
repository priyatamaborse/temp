package June19.July9_1;

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
       // SpringApplication.run(SpringBootApp.class, args);
        
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DIConfig.class);
       
       System.out.println("Spring container is Ready");
       
       Hello hello = (Hello)ctx.getBean("hello");
       hello.showHello();
       ctx.close();
    }
}
