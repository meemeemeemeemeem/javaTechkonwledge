package interfaces;

import java.awt.*;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * @author mei
 * @since 2023/7/18 11:07
 */
public class EmployeeSourtTest {
    Comparable x=new Employee("mei",123) ;

    public static void main(String[] args) {

        var staff = new Employee[3];
        staff[0]=new Employee("mei",3000);
        staff[1]=new Employee("shi",1000);
        staff[2]=new Employee("ka",2000);

        Arrays.sort(staff);

        for (Employee employee : staff) {
            System.out.println(employee.getName() +":"+employee.getSalary());
        }
    }
}



