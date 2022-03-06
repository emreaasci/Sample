package Homeworks.Java005.ornek3;
/* 3. x ve y pozitif tamsayılar olmak üzere eğer x sayısının kendisi hariç bölenleri toplamı y sayısına ve aynı
zamanda y sayısının kendisi hariç bölenleri toplamı x sayısına eşit ise bu sayılar arkadaştır denir. Örneğin 220
ve 284 sayıları arkadaş sayılardır. Parametre olarak aldığı iki tamsayının arkadaş olup olmadıklarını test eden
areFriends metodunu yazınız. Metodunuzu dört basamaklı bir arkadaş sayı çifti bulan bir kodla test
edebilirsiniz.
 */

public class App {
    public static void main(String[] argv) {
        NumberUtilTest.run();
    }
}

class NumberUtilTest{
    public static void run() {

        for(int i = 1000;i < 10000;i += 2) {
            for(int j = 1000;j < 10000 && i != j;j += 2) {
                if(NumberUtil.areFriends(i, j))
                    System.out.printf("%d ve %d sayıları arkadaştır.%n",i,j);
            }
        }
    }
}

class NumberUtil{
    public static boolean areFriends(int val1,int val2) {
        int sum1 = 0,sum2 = 0;
        sum1 = sumPrime(val1);
        sum2 = sumPrime(val2);

        if(sum1 == val2 && sum2 == val1)
            return true;

        return false;
    }

    public static int sumPrime(int val) {
        int sum = 0;
        for(int i = 1 ; i < val ;i++) {
            if(val % i == 0)
                sum += i;
        }

        return sum;
    }
}
