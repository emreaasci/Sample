package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.RecursionUtil;
import org.csystem.util.recursion.Util;

public class RecursiveWriteNumberRadixText {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for(;;){
            var s = Console.readInt("bir yazı giriniz:");
            RecursionUtil.writeNumber(s,16);

            Console.writeLine();

            if(s == 0)
                break;
        }
    }
}
