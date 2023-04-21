package study;

/**
 * @author mei
 * @since 2023/4/21 16:16
 */
public abstract class Person {
    private String name;

    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

}
