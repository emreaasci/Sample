package Homeworks.Java005.ornek4;
/* 4. Kendisi haricindeki tüm pozitif bölenlerinin toplamına eşit olan tamsayılara "mükemmel sayı" (perfect
number) denir. Örneğin 6 ve 28 sayıları mükemmel sayılardır:
6 = 1 + 2 + 3
28 = 1 + 2 + 4 + 7 + 14
a) Parametresi ile aldığı int türden bir değerin mükemmel sayı olup olmadığını test eden isPerfect metodunu
yazınız.
Metot sayı mükemmel ise true mükemmel değil ise false değerine geri dönecektir.
b) 4 basamaklı tek bir mükemmel sayı vardır. Yazmış olduğunuz isPerfect metodunu kullanarak 4 basamaklı
mükemmel sayıyı bulan programı yazınız.
*/

public class main {
    public static void main(String[] argv) {
        NumberUtilTest.run();
    }
}

class NumberUtilTest{
    public static void run() {

        for(int i = 1 ;i < 10000;i++) {
            if(NumberUtil.isPerfect(i))
                System.out.println(i);
        }
    }
}

class NumberUtil{
    public static boolean isPerfect(int val) {

        if(val == sumPrime(val))
            return true;

        return false;
    }

    public static int sumPrime(int val) {
        int sum = 0;
        for(int i = 1;i < val;i++) {
            if(val % i == 0)
                sum += i;
        }

        return sum;

    }
}