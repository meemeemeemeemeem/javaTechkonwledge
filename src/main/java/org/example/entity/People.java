package org.example.entity;

/**
 * @Author mei
 * @create 2023/1/1 17:04
 */
public class People {
    public People(String name, String old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    private String name;
    private String old;
}
