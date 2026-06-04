package com.NativeSQL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        EmployeeDao dao = context.getBean(EmployeeDao.class);

        
        dao.getAllEmployees();
        dao.getEmployee(574);
        dao.saveEmployee();
        dao.updateEmployee(50000, 574);
        dao.deleteEmployee(581);
    }
}