package study;

import java.util.Random;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        int i = 1;
    }
}

class Employee {
    private static int nextId;
    private int id;
    private String name;
    private double salary;


    public Employee() {
        this.name = "";
        this.salary = 0;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(double salary) {
        this("Employee #" + nextId, salary);
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


class Student {

    public static int nextId;

    private int id = assignId();

    static {
        var generator = new Random();
        nextId = generator.nextInt(10000);
        System.out.println(nextId);
    }

    private int assignId() {
        int r = nextId;
        nextId++;
        System.out.println(nextId);
        return r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}