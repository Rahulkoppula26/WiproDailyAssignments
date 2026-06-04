package Autowire.pri.qua;

import org.springframework.stereotype.Component;

@Component("Car")
public class Car implements Vehicle {
public void start() {
	System.out.println("Car is choosen by person");
}
}
