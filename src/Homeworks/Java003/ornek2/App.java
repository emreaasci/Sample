package Homeworks.Java003.ornek2;
/* 2. Aşağıda açıklanan isPrimeX isimli metodu yazınız:
isPrimeX metodu içerisinde, gönderilen argumanın asal olup olmadığı test edilecek, eğer sayı asal ise bu kez
sayının basamak değerleri toplanarak elde edilen sayının asal olup olmadığı test edilecektir. Bu işlem sonuçta tek
basamaklı bir sayı kalana kadar devam edilecektir. Eğer en son elde edilen tek basamaklı sayı dahil tüm sayılar
asal ise isPrimeX metodu true değerine geri dönecektir. Eğer herhangi bir kademede asal olmayan bir sayı elde
edilirse metot false değerine geri dönecektir.
*/

public class App {
    public static void main(String[] argv) {
        NumberUtilTest.run();
        //System.out.println(NumberUtil.sumDigits(159));
    }
}

class NumberUtilTest{
    public static void run() {
        for(int i = 0;i<10000;i++) {
            if(NumberUtil.isPrimeX(i))
                System.out.println(i);
        }
    }
}
class NumberUtil{

    public static boolean isPrimeX(int val) {
        if(isPrime(val)) {
            for(;;) {
                val = sumDigits(val);
                if(!isPrime(val))
                    return false;
                if(val < 10)
                    break;
            }

            return true;
        }

        return false;

    }

    public static int sumDigits(int val) {
        int sum = 0,kalan;
        int temp = val;

        while(temp != 0) {
            kalan = temp % 10;
            sum += kalan;
            temp /= 10;
        }

        return Math.abs(sum);
    }



    public static boolean isPrime(int val) {

        if(val <= 1)
            return false;
        if(val % 2 == 0)
            return val == 0;
        if(val % 3 == 0)
            return val == 3;
        if (val % 7 == 0)
            return val == 7;

        int sqrtVal =  (int)Math.sqrt(val);

        for(int i = 11;i <= sqrtVal;i++) {
            if(val % i == 0)
                return false;
        }

        return true;

    }

}