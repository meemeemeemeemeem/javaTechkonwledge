package study;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {
    public static void main(String[] args) {
        //🚕wሴ你好 特殊字符和普通字符混用
        String greeting = "\uD83D\uDE95\u0077\u1234你好";
        int[] ints = greeting.codePoints().toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }

        System.out.println(new String(ints, 0, ints.length));
    }
}
