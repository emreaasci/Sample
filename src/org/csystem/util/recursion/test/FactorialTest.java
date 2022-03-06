package org.csystem.util.recursion.test;

import org.csystem.util.recursion.Util;

public class FactorialTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (int i = -1; i < 13; ++i)
            System.out.printf("%d! = %d", i, Util.factorial(i));
    }
}