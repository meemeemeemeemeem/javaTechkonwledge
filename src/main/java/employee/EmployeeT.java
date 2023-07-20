package employee;

import java.util.Random;

/**
 * @author mei
 * @since 2023/6/30 15:29
 */
public class EmployeeT {
    public static  int nextId;
    private int id;
    private String name = "";
    private double salary;
    {
        var generator = new Random();
        nextId = generator.nextInt(10000);
        System.out.println(nextId);
    }
    {
        id = nextId;
        nextId++;
    }
    static {
        System.out.println(11);
    }
    public EmployeeT(String name,double salary){
        this.name=name;
        this.salary=salary;
        System.out.println(name);
        System.out.println(salary);
    }
    public EmployeeT(double salary){
        this("Employee #"+nextId,salary);
    }
}
class Tes{
    public static void main(String[] args) {
        EmployeeT employeeT = new EmployeeT(10000);
        System.out.println(EmployeeT.nextId);
    }
}