package study;


import org.example.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {
    public static void main(String[] args)  {
        Employee employee = new Employee("mei",50000,2012,12,31);
        System.out.println(employee.getName()+employee.getSalary()+employee.getHireDay());
        employee.raiseSalary(5);
        System.out.println(employee.getSalary());

    }
}