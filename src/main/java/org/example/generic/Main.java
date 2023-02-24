package org.example.generic;

import org.example.entity.Man;
import org.example.entity.People;
import org.example.entity.Son;

import java.awt.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author mei
 * @create 2023/1/1 14:11
 */
public class Main<T> {
    public static void main(String[] args) {
        People people = new People();
        Man man=new Man();
        Son son = new Son();

        Test<People>peopleTest=new Test<>();
        peopleTest.setData(people);
        peopleTest.setData(man);
        peopleTest.setData(son);

        People peopleData = peopleTest.getData();


    }


}
