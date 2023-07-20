package lambda;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * @author mei
 * @since 2023/7/20 15:18
 */
public class LambdaTest {
    public static void main(String[] args) {
        var planets = new String[]{"mei","shi","hao","wang","yang"};
        System.out.println(Arrays.toString(planets));
        System.out.println("按字典排序后:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("按长度排序:");
        Arrays.sort(planets,(first,second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));

        var timer=new Timer(1000, event->
                System.out.println("this time is"+new Date()));
        timer.start();

        JOptionPane.showMessageDialog(null,"quit program");
        System.exit(0);
    }
}
