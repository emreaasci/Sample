package Homeworks.Java005.ornek2;

/* 2. Parametresi ile aldığı pozitif bir tamsayının kendisi hariç tüm çarpanlarının toplamı ile geri dönen sumFactors
metodunu yazınız. Metot parametresi ile aldığı sayı hariç tüm çarpanlarının toplamını geri dönecektir: (1 her
sayının doğal çarpanıdır ve toplama dahil edilecektir.)

*/

public class App {
    public static void main(String[] argv) {
        NumberUtilTest.run();
    }
}

class NumberUtilTest{
    public static void run() {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("bir sayi giriniz:");

        int val = Integer.parseInt(scan.nextLine());

        System.out.println(NumberUtil.sumFactors(val));
    }
}

class NumberUtil{
    public static int sumFactors(int val) {
        int sum = 0;
        int prime = 2;

        for(prime = 1;prime < val;prime++) {
            if(val % prime == 0) {
                System.out.println(prime);
                sum += prime;
            }
        }

        return sum;
    }
}