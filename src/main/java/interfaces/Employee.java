package interfaces;

/**
 * @author mei
 * @since 2023/7/18 14:25
 */
public class Employee implements Comparable<Employee>{

    private String name;
    private double salary;

    public Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent){
        double raise = this.salary*byPercent/100;
        this.salary+=raise;
    }


    @Override
    public int compareTo(Employee other) {
        return  Double.compare(this.salary,other.salary);
    }
}
