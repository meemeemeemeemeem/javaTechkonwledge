package study;


import java.awt.*;
import java.lang.System;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("how many numbers do you need to draw");
        int k = in.nextInt();
        System.out.println("high number");
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=i+1;
        }
        int[] result=new int[k];
        for (int i = 0; i < result.length; i++) {
            int r =(int)Math.random()*n;
            result[i]=numbers[r];
            numbers[r]=numbers[n-1];
            n--;
        }
        Arrays.sort(result);
        for (int r :result) {
            System.out.println(r);
        }
    }
}