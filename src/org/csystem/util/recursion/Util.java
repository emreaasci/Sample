package org.csystem.util.recursion;

import org.csystem.util.Console;

public final class Util {
    private Util() {
        
    }

    public static long factorial(int a){
        long result = 1;

        for(int i = 2; i <= a;i++){
            result *= i;
        }

        return result;
    }

    public static void writeReverse(String str){

        for(int i = str.length() - 1;i >= 0;i--)
            System.out.write(str.charAt(i));

        System.out.flush();
    }

    public static String getReversed(String str){
        char [] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while(left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return String.valueOf(chars);
    }

    public static int getFibonacciNumber(int n){
        if(n <= 0){
            return -1;
        }

        if(n <= 2){
            return n - 1;
        }

        int prev1 = 1, prev2 = 0, val = 0;

        for(int i = 2;i < n;i++){
            val = prev1 + prev2;
            prev2 = prev1;
            prev1 = val;
        }

        return val;
    }
    //TODO:
    public static void writeNumber(int val,int radix) {

        if(val == 0){
            System.out.write('0');
            return;
        }

        char [] s = new char[11];
        int i;
        boolean isNegative = false;

        if(val < 0){
            isNegative = true;
            val = -val;
        }

        for(i = 0; val != 0;++i){
            s[i] = (char)((char) ((val % radix >= 10 ? 'A' - 10 : '0') + val % radix));
            val /= radix;
        }

        if(isNegative)
            s[i++] = '-';

        for(--i; i>= 0;i--)
            System.out.write(s[i]);

        System.out.flush();
    }

}
