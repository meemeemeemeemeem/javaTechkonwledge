package study;

/**
 * @author mei
 * @since 2023/4/19 16:34
 */
public class Manager extends Employee {
    private double bonus;
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year,month,day);
    }
    public double getSalary(){
        double baseSalary=super.getSalary();
        return baseSalary+this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public Manager get() {
        return this;
    }
}
