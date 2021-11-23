package org.example;

import org.example.Config.MyConfig;
import org.example.Model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmps = communication.getAll();
//        System.out.println(allEmps);

//        Employee empById = communication.getOne(2L);
//        System.out.println(empById);

//        Employee employee = new Employee("Dmitry", "Strezhenyk", "IT", 2500 );
//        employee.setId(6L);
//        communication.save(employee);

        communication.delete(6L);
    }
}
