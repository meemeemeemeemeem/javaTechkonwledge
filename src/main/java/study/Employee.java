package study;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author mei
 * @since 2023/4/19 16:34
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return Objects.equals(this.getHireDay(), other.getHireDay())
                &&
                Objects.equals(this.getName(),other.getName())
                &&
                this.salary==other.salary;
    }



    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

}
