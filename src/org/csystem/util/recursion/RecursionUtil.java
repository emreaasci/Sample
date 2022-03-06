package org.csystem.util.recursion;

import org.csystem.util.Console;

public final class RecursionUtil {

    private RecursionUtil(){

    }

    private static void writeNumberRecur(int val, int radix) {
        if(val / radix != 0){
            writeNumberRecur(val / radix,radix);
        }

        System.out.write((char)((val % radix >= 10 ? -10 +'A' : '0') + val % radix));
    }

    private static int getFibonacciNumberRecur(int n){
        if(n <= 2)
            return n - 1;

        return getFibonacciNumberRecur(n -1) + getFibonacciNumberRecur(n - 2);

    }
    private static void writeReverse(String s,int i){
        if(i == s.length())
            return;

        writeReverse(s,i + 1);

        System.out.write(s.charAt(i));
    }

    private static void getReversed(char [] ch, int left, int right){
        if(left >= right)
            return;

        char temp = ch[left];
        ch[left] = ch[right];
        ch[right] = temp;

        getReversed(ch,left + 1,right - 1);

    }

    public static long factorial(int n)
    {
        long result;

        if (n <= 0)
            return 1;

        result = n * factorial(n - 1);

        return result;
    }

    public static void writeReverse(String s){
        writeReverse(s,0);
        System.out.flush();
    }

    public static String getReversed(String str){
        char [] c = str.toCharArray();
        getReversed(c,0,c.length - 1);

        return String.valueOf(c);
    }
    public static int getFibonacciNumber(int n){
        if(n <= 0)
            return -1;

        return getFibonacciNumberRecur(n);
    }

    public static void writeNumber(int val) {
        writeNumber(val,10);
    }

    public static void writeNumber(int val, int radix) {
        if(val < 0){
            System.out.write('-');
            val = -val;
        }
        writeNumberRecur(val , radix);
        System.out.flush();
    }
}