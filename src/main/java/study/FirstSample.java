package study;


import org.example.Employee;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {
    private final String name="";
    public static void main(String[] args)  {

        Employee employee = new Employee("mei",50000,2012,12,31);
        System.out.println(Employee.getNextid());
        Employee employee1 = new Employee("mei",50000,2012,12,31);
        System.out.println(Employee.getNextid());

    }
}