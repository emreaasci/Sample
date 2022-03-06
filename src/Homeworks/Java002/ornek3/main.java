package Homeworks.Java002.ornek3;

import java.util.Scanner;

/* 3. Bir sayının asal çarpanlarını yazdıran programı yazınız. Örneğin:
Sayı: 12
2 2 3

*/

public class main {
    public static void main(String[] argv) {
        run.asal();
    }
}

class run{
    public static void asal() {
        Scanner scan = new Scanner(System.in);
        System.out.print("bir sayi giriniz:");
        int sayi = scan.nextInt();

        int asal = 2;

        for(asal = 2;asal<=sayi;asal++) {
            if(sayi % asal == 0) {
                System.out.println(asal);
                sayi = sayi / asal;
                asal--;
            }

        }

    }
}