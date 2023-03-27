package study;


import org.example.entity.People;

import java.awt.*;
import java.util.Arrays;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {

    public static void main(String[] args) {
        String[]i = {"123","234"};
        String[]j = i;
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));
        System.out.println(i);
        System.out.println(j);
        i[0]="111";
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));
        System.out.println(i);
        System.out.println(j);

        j[0]="222";
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));
        System.out.println(i);
        System.out.println(j);





    }

}