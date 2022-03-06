package Homeworks.Java009.ornek1;
/*1. “Mastermind” isimli oyun iki kişi ile oynanan bir sayı bulmaca oyunudur. Oyunculardan biri, [1000 - 9999]
kümesinden basamak değerleri birbirinden farklı bir sayı belirler. Diğer oyuncunun amacı bu sayıyı en fazla 10
tahminde bulmaktır. Sayıyı belirleyen oyuncu, diğer oyuncunun her tahmininden sonra oyunun kuralları
doğrultusunda bilgiler vermektedir.
- Tahmin edilen sayı içerisinde belirlenen sayının içerisindeki rakamlardan biri varsa fakat basamak değeri
tutmuyorsa - işareti ile, basamak değeri de tutuyorsa + işareti ile bilgi verilir. Örnekler:

Belirlenen sayı : 1234
Tahmin edilen sayı : 4567
Verilecek bilgi : -

Belirlenen sayı : 1234
Tahmin edilen sayı : 5674
Verilecek bilgi : +

Belirlenen sayı : 1234
Tahmin edilen sayı : 4237
Verilecek bilgi : +2 -

Not: Verilecek olan bilgide + ve - 'lerin sırasının bir önemi yoktur.
Bir sayı belirleyerek mastermind oyununu oynatan programı yazınız.
 */

import org.csystem.util.NumberUtil;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String [] argv){
        Scanner scan = new Scanner(System.in);
        MasterMind game1 = new MasterMind();

        for(;;){
            System.out.print("bir tahmin sayısı giriniz:");
            int guess = Integer.parseInt(scan.nextLine());

            if(guess <= 0)
                break;

            if(!game1.getInfo(guess))
                ;

            else{
                System.out.println("tebrikler oyunu kazandınız...");
                break;
            }
        }

    }
}

class GenerateNumber {
    public Random r;

    public GenerateNumber(){
        r = new Random();
    }

    public int [] randomNum(){
        int [] numbers = new int[4];

        for(int i = 0;i < 4;i++){
            boolean repeat;

            do{
                repeat = false;

                numbers[i] = r.nextInt(9) + 1;

                for(int k = 0;k < i;k++){
                    if(numbers[i] == numbers[k]){
                        repeat = true;
                        break;
                    }
                }

            }while(repeat);
        }

        return numbers;
    }
}

class MasterMind{
    public int [] num;

    public MasterMind(){
        num =  new GenerateNumber().randomNum();
        System.out.print("NUM = ");
        for(int i = 0;i < 4 ;i++)
            System.out.printf("%d",num[i]);

        System.out.println();
    }

    public boolean getInfo(int guessnum){
        int [] guess = NumberUtil.getDigits(guessnum);
        int sameDigits = 0;
        int diffDigits = 0;

        for(int i = 0;i < guess.length;i++){
            for(int k = 0;k < num.length;k++){
                if(guess[i] == num[k]){
                    if(i == k)
                        sameDigits++;
                    else
                        diffDigits++;
                }
            }
        }

        System.out.printf("( +%d) (-%d)%n",sameDigits,diffDigits);

        if(sameDigits == 4)
            return true;


        return false;
    }


}