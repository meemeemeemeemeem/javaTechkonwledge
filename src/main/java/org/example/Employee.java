package org.example;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @Author mei
 * @create 2023/3/29 16:41
 */
public class Employee {
    private String name;
    private LocalDate hireDay;
    private double salary;

    public Employee(String n, double salary, int year, int month, int day) {
        name = Objects.requireNonNull(n, "the name can not be null");
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }


    public LocalDate getHireDay() {
        return hireDay;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
