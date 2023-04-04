package study;


import java.text.NumberFormat;
import java.time.LocalDate;

/**
 * @Author mei
 * @create 2023/1/9 11:32
 */
public class FirstSample {

    public static void main(String[] args)  {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        System.out.println(currencyFormatter.format(0.1));
        System.out.println(percentFormatter.format(0.1));

    }
}