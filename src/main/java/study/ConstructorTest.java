package study;


import java.sql.Date;
import java.util.Map;
import java.util.Random;



/**
 * @Author mei
 * @create 2023/4/11 14:53
 */
public class ConstructorTest {
    public static void main(String[] args) {
        var staff = new EmployeeT[3];

        staff[0]=new EmployeeT("harry",40000);
        staff[1]=new EmployeeT(60000);
        staff[2]=new EmployeeT();

        for (EmployeeT employeeT : staff) {
            System.out.println("name ="+employeeT.getName()+",id="+employeeT.getId()+",salary="+employeeT.getSalary());

        }
    }
}





class EmployeeT{
    private static  int nextId;

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
    public EmployeeT(String name,double salary){
        this.name=name;
        this.salary=salary;
    }
    public EmployeeT(double salary){
        this("Employee #"+nextId,salary);
    }
    public EmployeeT(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}