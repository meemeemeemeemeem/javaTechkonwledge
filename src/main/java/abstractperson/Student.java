package abstractperson;

/**
 * @author mei
 * @since 2023/4/21 16:31
 */
public abstract class Student extends Person {
    private String major;

    public Student() {
    }

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }
}
