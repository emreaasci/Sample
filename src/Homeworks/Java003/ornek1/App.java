package Homeworks.Java003.ornek1;

/* Çalışma Soruları
1. abc üç basamaklı bir tamsayıdır ve aşağıdaki koşulları sağlamaktadır:
koşul 1 cba > abc olacak
koşul 2 abc asal sayı olacak
koşul 3 cba asal sayı olacak
koşul 4 ab asal sayı olacak
koşul 5 bc asal sayı olacak
koşul 6 cb asal sayı olacak
koşul 7 ba asal sayı olacak
113 sayısı bu koşulları sağlamaktadır!
koşul 1 cba > abc olacak 311 > 113
koşul 2 abc asal sayı olacak 113 asal
koşul 3 cba asal sayı olacak 311 asal
koşul 4 ab asal sayı olacak 11 asal
koşul 5 bc asal sayı olacak 13 asal
koşul 6 cb asal sayı olacak 31 asal
koşul 7 ba asal sayı olacak 11 asal
Yukarıdaki koşulların hepsini sağlayan tüm abc sayılarını bulan programı yazınız.
*/

public class App {
    public static void main(String[] argv) {

        NumberUtilTest.run();
    }
}

class NumberUtilTest{
    public static void run() {

        for(int i = 0 ; i < 1000;i++) {
            if(NumberUtil.abc(i))
                System.out.println(i);
        }
    }
}

class NumberUtil{

    public static boolean abc(int val) {
        int reverse = reversed(val);

        if(val < 100)
            return false;

        if(reverse <= val)
            return false;

        if(!isPrime(reverse) && !isPrime(val))
            return false;

        if(!isPrime(val / 10))
            return false;

        if(!isPrime(reverse / 10))
            return false;

        if(!isPrime(val % 100))
            return false;

        if(!isPrime(reverse % 100))
            return false;


        return true;

    }

    public static boolean isPrime(int val) {

        if(val <= 1)
            return false;
        if(val % 2 == 0)
            return val == 2;
        if(val % 3 == 0)
            return val == 3;
        if(val % 5 == 0)
            return val == 5;
        if(val % 7 == 0)
            return val == 7;

        for(int i = 11;i < val;i += 2) {
            if(val % i == 0)
                return false;
        }

        return true;
    }

    public static int reversed(int val) {
        int reverse = 0;

        while(val != 0) {
            reverse = reverse * 10 + val % 10;
            val /= 10;
        }

        return reverse;
    }
}