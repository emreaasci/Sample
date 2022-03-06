package org.csystem.util.bitwise;

import org.csystem.util.Console;

public final class BitwiseUtil {
    private BitwiseUtil(){
    }

    /*private static void writeBits(String bitStr,int bitsLength){
        int lengthOfZeros = bitsLength - bitStr.length();

        Console.writeLine(lengthOfZeros != 0 ? String.format("%0" + lengthOfZeros + "d%s",0,bitStr) : bitStr);
    }*/

    // sayının bitlerini ekreana basar
    public static void writeBits(int val){
        for(int i = 31;i >= 0;--i)
            Console.write((val & 1 << i) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(long val){
        for(int i = 63;i >= 0;--i)
            Console.write((val & 1L << i) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(short val){
        for(int i = 15;i >= 0;--i)
            Console.write((val & 1 << i) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(byte val){
        for(int i = 7;i >= 0;--i)
            Console.write((val & 1 << i) != 0 ? 1 : 0);

        Console.writeLine();
    }

    public static void writeBits(char val){
        for(int i = 15;i >= 0;--i)
            Console.write((val & 1 << i) != 0 ? 1 : 0);

        Console.writeLine();
    }

    // setBit bir sayının belirli bir bitini(k) 1 yapar.
    public static int setBit(int val,int k){ //[0,31]
        return val | 1 << k;
    }

    public static long setBit(long val,int k){ //[0,63]
        return val | 1L << k;
    }

    public static short setBit(short val,int k){ //[0,15]
        return (short)(val | 1 << k);
    }

    public static byte setBit(byte val,int k){ //[0,17]
        return (byte)(val | 1 << k);
    }

    public static char setBit(char val,int k){ //[0,63]
        return (char)(val | 1 << k);
    }
    // clearBit bir sayının berlirli bir bitini(k) 0 yapar.
    public static int clearBit(int val,int k){ //[0,31]
        return val & ~(1 << k);
    }

    public static long clearBit(long val,int k){
        return val & ~(1L << k);
    }

    public static short clearBit(short val,int k){
        return (short)(val & ~(1 << k));
    }

    public static byte clearBit(byte val,int k){
        return (byte) (val & ~(1 << k));
    }

    public static char clearBit(char val,int k){
        return (char) (val & ~(1 << k));
    }

    //toggleBit  bir sayının belirli bir bitinin değerini değiştirir(0 ise 1, 1 ise 0 yapar).
    public static int toggleBit(int val,int k){
        return val ^ 1 << k;
    }

    public static long toggleBit(long val,int k){
        return val ^ 1L << k;
    }

    public static short toggleBit(short val,int k){
        return (short) (val ^ 1 << k);
    }

    public static byte toggleBit(byte val,int k){
        return (byte) (val ^ 1 << k);
    }

    public static char toggleBit(char val,int k){
        return (char) (val ^ 1 << k);
    }

    // tek mi çift mi (true = çift, false = tek)
    public static boolean isEven(int val){
        return isClear(val,0);
    }

    //satının belirli bir bitini elde eder.(true = 1,false = 0)
    public static boolean isSet(int val,int k){
        return (val & 1 << k) != 0;
    }

    public static boolean isSet(long val,int k){
        return (val & 1 << k) != 0;
    }

    //satının belirli bir bitini elde eder.(true = 0,false = 1)
    public static boolean isClear(int val,int k){
            return !isSet(val,k);
    }

    public static boolean isClear(long val,int k){
        return !isSet(val,k);
    }

    // 2'nin kuvveti olup olmadığını kontrol eder
    public static boolean isPowerOfTwo(int val){
        return (val & (val - 1)) == 0;
    }

    // sayının 1 olan bitlerin sayısını döner
    public static int numberOfSetBits(int val){
        int count = 0;
        for(int i = 0;i < 32; i++){
            if((val & 1 << i) != 0)
                count++;
        }
        return count;
    }

    public static int numberOfSetBits(long val){
        int count = 0;
        for(int i = 0;i < 64; i++){
            if((val & 1L << i) != 0)
                count++;
        }
        return count;
    }

    public static int numberOfSetBits(short val){
        int count = 0;
        for(int i = 0;i < 16; i++){
            if((val & 1 << i) != 0)
                count++;
        }
        return count;
    }

    // sayının 0 olan bitlerin sayısını döner.
    public static int numberOfClearBits(int val){
        return 32 - numberOfSetBits(val);
    }

    public static int numberOfClearBits(long val){
        return 64 - numberOfSetBits(val);
    }

    public static int numberOfClearBits(short val){
        return 16 - numberOfSetBits(val);
    }

    // sayının bitlerinin string karşılığını döner.
    public static String toBitsString(int val){
        StringBuilder sb = new StringBuilder(32);

        for(int i = 31;i >= 0;i--)
            sb.append((val & 1 << i) != 0 ? '1' : '0');

        return sb.toString();
    }

    public static String toBitsString(long val){
        StringBuilder sb = new StringBuilder(64);

        for(int i = 63;i >= 0;i--)
            sb.append((val & 1L << i) != 0 ? '1' : '0');

        return sb.toString();
    }

    public static String toBitsString(short val){
        StringBuilder sb = new StringBuilder(16);

        for(int i = 15;i >= 0;i--)
            sb.append((val & 1 << i) != 0 ? '1' : '0');

        return sb.toString();
    }

    public static String toBitsString(char val){
        StringBuilder sb = new StringBuilder(32);

        for(int i = 15;i >= 0;i--)
            sb.append((val & 1 << i) != 0 ? '1' : '0');

        return sb.toString();
    }

    // 1 olan bitlerin indexlerinin bulunduğu diziyi döner.
    public static int[] indicesOfSetBits(int val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 32 ;k++)
            if( (val & 1 << k) != 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfSetBits(long val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 64 ;k++)
            if( (val & 1L << k) != 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfSetBits(short val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 16 ;k++)
            if( (val & 1 << k) != 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfSetBits(byte val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 8 ;k++)
            if( (val & 1 << k) != 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfSetBits(char val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 16 ;k++)
            if( (val & 1 << k) != 0)
                bits[index++] = k;

        return bits;
    }

    // 0 olan bitlerin indexlerinin bulunduğu diziyi döner.
    public static int[] indicesOfClearBits(int val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 32 ;k++)
            if( (val & 1 << k) == 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfClearBits(long val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 64 ;k++)
            if( (val & 1L << k) == 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfClearBits(short val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 16 ;k++)
            if( (val & 1 << k) == 0)
                bits[index++] = k;

        return bits;
    }

    public static int[] indicesOfClearBits(byte val){
        int [] bits = new int[numberOfSetBits(val)];
        int index = 0;

        for(int k = 0; k < 8 ;k++)
            if( (val & 1 << k) == 0)
                bits[index++] = k;

        return bits;
    }






}
