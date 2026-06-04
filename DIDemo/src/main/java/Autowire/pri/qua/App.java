package Autowire.pri.qua;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Person obj = context.getBean(Person.class);
		obj.travel();
	}

}
