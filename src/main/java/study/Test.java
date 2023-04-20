package study;

/**
 * @author mei
 * @since 2023/4/19 16:34
 */
public class Test {
    public static void main(String[] args) {
        Manager[]managers=new Manager[10];
        Employee[]staff = managers;
        System.out.println(staff[0].getClass().getName());

        staff[0]=new Employee("Harry ",5000,1988,10,12);
        managers[0].setBonus(12);

    }

}
