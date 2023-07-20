package clone;

/**
 * @author mei
 * @since 2023/7/20 10:08
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var original=new Employee("John",5000);
        original.setHireDay(2000,1,1);
        Employee copy=original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2002,12,12);
        System.out.println(original);
        System.out.println(copy);
    }
}
