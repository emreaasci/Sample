package Homeworks.Java002.ornek5;
/* 5. 2’den büyük tüm çift sayılar iki asal sayının toplamı biçiminde yazılabilir (Goldbach teoremi). Klavyeden bir
çift sayı alan ve bunu iki asal sayının toplamı biçiminde yazdıran programı yazınız. Örneğin:
Sayı: 16
11 + 5
*/

public class App {
    public static void main(String [] argv) {
        NumberUtil.goldbach(28); // çift sayi yaz

    }
}

class NumberUtil{
    public static void goldbach(int val) {

        boolean flag = false;

        for(int i = 2;i < val ;i++) {
            for(int j = 2;j<val/2;j++) {
                if(isPrime(i) && isPrime(j) && i + j == val) {
                    System.out.printf("%d + %d = %d%n",i,j,val);
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
    }

    public static boolean isPrime(int val) {

        if (val <= 1)
            return false;
        if (val % 2 == 0)
            return val == 2;
        if (val % 3 == 0)
            return val == 3;
        if (val % 5 == 0)
            return val == 5;
        if (val % 7 == 0)
            return val == 7;

        for(int i = 11; i * i <= val;i++) {
            if(val % i == 0) {
                return false;
            }
        }
        return true;
    }
}