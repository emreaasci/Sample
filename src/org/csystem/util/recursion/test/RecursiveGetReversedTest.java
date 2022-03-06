package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.RecursionUtil;

public class RecursiveGetReversedTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for(;;){
            var s = Console.read("bir yazı giriniz:");
            Console.write(RecursionUtil.getReversed(s));

            Console.writeLine();

            if(("quit".equals(s)))
                break;
        }
    }
}