package Homeworks.Java007.ornek1;

/* 1. Bir tombala torbasında 1'den 99'a kadar numaralanmış (99 dahil) pullar bulunmaktadır. Bu tombala torbasıyla
aşağıdaki oyunlar oynanmaktadır:
Çekilen bir pul torbaya geri atılmamak üzere
i) Torbadan 3 pul çekiliyor. Çekilen pulların toplamı 150' den küçük ise oyuncu kazanıyor.
ii) Torbadan 3 pul çekiliyor. Çekilen pulların toplamı asal sayı ise oyuncu kazanıyor.
iii) Torbadan 3 pul çekiliyor. En büyük değerli pul ile en küçük değerli pul arasındaki fark ortanca değerli puldan
büyükse oyuncu kazanıyor.
Oynanacak her bir oyun için oyuncunun kazanma olasılığını en az 30000 oyunu simule ederek hesaplayınız!
*/

import java.util.Random;
import java.util.Scanner;
import org.csystem.util.ArrayUtil;
import org.csystem.util.NumberUtil;

public class App {
    public static void main(String [] argv){
        Scanner scan = new Scanner(System.in);
        Bingo tombala1 = new Bingo();


        for(;;){
            System.out.print("kaç kere oynamak istiyorsunuz:");
            int n = Integer.parseInt(scan.nextLine());

            if(n <= 0)
                break;

            int count = 0;

            for(int k = 0;k < n;k++){
                if(tombala1.game())
                    count++;

            }

            System.out.printf("oyunu kazanma oranınız: %f%n",(double) count / n );

        }


    }
}

class Bingo {
    public Random r;

    public Bingo() {
        r = new Random();
    }

    public boolean [] getFlags() {
        boolean [] flags = new boolean[100];

        for(int i = 0;i < 3;i++){
            int index;
            for(;;){
                index = r.nextInt(99) + 1;
                if(!flags[index])
                    break;
            }

            flags[index] = true;
        }

        return flags;
    }

    public int [] getNumbers(boolean [] flags){
        int [] numbers = new int[3];
        int index = 0;

        for(int i = 0;i < flags.length ;i++){
            if(flags[i]) {
                numbers[index] = i;
                index++;
            }
        }

        return numbers;
    }

    public int [] getNumbers(){
        return getNumbers(getFlags());
    }

    public boolean game(){
        int [] gamea = getNumbers();
        int sum = ArrayUtil.sum(gamea);
        int diff = gamea[2] - gamea[0];

        return sum > 150 || NumberUtil.isPrime(sum) || diff < gamea[1];
    }


}


