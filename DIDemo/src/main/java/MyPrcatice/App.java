package MyPrcatice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
		Student obj= context.getBean(Student.class);
        obj.display();
	}

}
