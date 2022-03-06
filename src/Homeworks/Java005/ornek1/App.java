package Homeworks.Java005.ornek1;

/* 1. e sayısını aşağıdaki seri toplamıyla bulabilirsiniz :
Bir Java programı yazarak e sayısını yukarıdaki seri toplamıyla hesaplayarak ekrana yazdırınız.
e = 1 / 0! + 1 / 1! + 1 / 2! + ! / 3! + ....
*/

public class App {
    public static void main(String[] argv) {
        System.out.println(Util.getE());
    }
}

class Util{
    public static double getE() {
        double e = 0;

        for(int i = 0;i< 10 ;i++) {
            e += 1. / NumberUtil.factorial(i);
        }

        return e;
    }
}

class NumberUtil{

    public static int factorial(int val) {
        int fak = 1;

        for(int i = 2;i <= val ;i++)
            fak *= i;

        return fak;
    }
}