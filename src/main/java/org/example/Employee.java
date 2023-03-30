package org.example;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @Author mei
 * @create 2023/3/29 16:41
 */
public class Employee {
    private String name;
    private LocalDate hireDay;
    private double salary;
    private final Date date;
    private static int nextid;


    public Employee(String n, double salary, int year, int month, int day) {
        this.name = Objects.requireNonNull(n, "the name can not be null");
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
        this.date=new Date();
        nextid++;
    }

    public static int getNextid() {
        return nextid;
    }


    public void giveGoldStar(){
        this.date.setTime(100);
    }
}
