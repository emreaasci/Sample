package org.csystem.util.recursion.test;

import org.csystem.util.recursion.RecursionUtil;

import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveFactorialTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (int i = -1; i < 13; ++i) {
            System.out.printf("%d! = %d", i, RecursionUtil.factorial(i));
            System.out.println();

        }

        System.out.println();
    }
}