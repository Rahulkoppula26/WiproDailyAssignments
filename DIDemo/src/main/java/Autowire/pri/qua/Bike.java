package Autowire.pri.qua;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Bike")
@Primary
public class Bike implements Vehicle{
	public void start() {
		System.out.println("Bike is choosen by person");
	}
}
