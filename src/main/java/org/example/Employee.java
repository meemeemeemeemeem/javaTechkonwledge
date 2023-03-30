package org.example;

import java.time.LocalDate;

/**
 * @Author mei
 * @create 2023/3/29 16:41
 */
public class Employee {
    private String name ;
    private LocalDate hireDay;
    private double s;
    public Employee(String n,double salary,int year,int month ,int day){
        this.name=n;
        s=salary;
        hireDay=LocalDate.of(year, month,day);

    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }
}
