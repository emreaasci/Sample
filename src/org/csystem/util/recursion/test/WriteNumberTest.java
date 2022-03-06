package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.Util;

public class WriteNumberTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for(;;){
            var s = Console.readInt("bir sayı giriniz:");
            var radix = Console.readInt("radix değerini giriniz:");
            Util.writeNumber(s,radix);

            Console.writeLine();

            if(s < 0)
                break;
        }
    }
}