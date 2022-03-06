package Homeworks.Java012.ornek3;
/* 3. Klavyeden girilen bir long türden sayıyı ekrana yazı olarak yazdıran programı yazınız. Örneğin:
Lütfen bir sayı giriniz: 12345678
on iki milyon üç yüz kırk beş bin altı yüz yetmiş sekiz
Not: Rakamlar arasında yalnızca bir adet boşluk karakteri bulunmalıdır.
 */

import org.csystem.util.NumberUtil;

import java.util.Scanner;

public class App {
    public static void main(String[] argv){
        Scanner scan = new Scanner(System.in);

        for(;;){
            System.out.print("bir sayı giriniz:");
            int val = Integer.parseInt(scan.nextLine());

            String a = NumberToWords.numToStr(val);

            System.out.println(a);

            if(val == 0)
                break;
        }

    }
}

class NumberToWords {

    public static String numToStr (long val){
        int [] digits = DigitParts(val,3);

        String result = "";

        switch (digits.length){
            case 3:
                result += numbertotext(digits[digits.length - 3]) + "milyon ";
            case 2:
                if(digits.length > 2)
                    result += numbertotext(Math.abs(digits[digits.length - 2])) + "bin ";
                else
                    result += numbertotext(digits[digits.length - 2]) + "bin ";
            case 1:
                if(digits.length > 1)
                    result += numbertotext(Math.abs(digits[digits.length - 1])) + "";
                else
                    result += numbertotext(digits[digits.length - 1]) + "";
                break;
        }

        return result;
    }

    public static int [] DigitParts(long val, int n){
        int [] digits = new int[val == 0 ? 1 : (int)(Math.log10(Math.abs(val)) / n) + 1];
        int powofTen = (int)Math.pow(10, n);

        for(int i = digits.length - 1;i >= 0;i--){
            digits[i] = (int)val % powofTen;
            val /= powofTen;
        }

        return digits;
    }

    public static String numbertotext(int val){
        if(val == 0)
            return "sıfır";

        String [] ones = {"","bir ","iki ","üç ","dört ","beş ","altı ","yedi ","sekiz ","dokuz "};
        String [] tens = {"", "on ","yirmi ","otuz ","kırk ","elli ","altmış ","yetmiş ","seksen ","doksan "};

        String str = val < 0 ? "eksi " : "";
        val = Math.abs(val);

        int a,b,c;

        a = val / 100;
        b = (val / 10) % 10;
        c = val % 10;

        if(a != 0) {
            if (a != 1)
                str += ones[a];
            str += "yüz ";
        }

        if(b != 0)
            str += tens[b];

        if(c != 0)
            str += ones[c];

        return str;
    }


}
