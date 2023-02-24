package org.example.linkList;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Author mei
 * @create 2023/1/4 17:27
 */
public class Main {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        System.out.println(decimalFormat.format(new BigDecimal("8.000000")));
    }
}

