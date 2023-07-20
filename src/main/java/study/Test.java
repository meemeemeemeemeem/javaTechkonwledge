package study;



import employee.EmployeeT;
import interfaces.Employee;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

/**
 * @author mei
 * @since 2023/4/19 16:34
 */
public class Test extends Employee{

    public Test(String name, double salary) {
        super(name, salary);
    }



    public static void main(String[] args)  {
        Comparator<String>comparator= Comparator.comparingInt(String::length);
        Employee employee=new Employee("h",5000);
        int[] clone = new int[]{1, 2}.clone();

    }

}
