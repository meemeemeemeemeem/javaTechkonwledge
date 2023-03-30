package study;


import org.example.Employee;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {
    public static void main(String[] args)  {

        Employee employee = new Employee("mei",50000,2012,12,31);
        System.out.println(employee.getName()+" "+employee.getSalary()+" "+employee.getHireDay());

        double tenYearsInMilliSeconds= 10*365.25*24*60*60*1000;

        System.out.println(employee.getHireDay().hashCode());

    }
}