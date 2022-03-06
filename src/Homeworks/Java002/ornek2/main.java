package Homeworks.Java002.ornek2;

/* 2. Parametresi ile aldığı long türden saniye cinsinden süreyi saat, dakika ve saniye olarak ayrıştırarak ekrana
yazdıran displayDuration isimli metodu yazınız. Eğer saat, dakika ya da saniye değeri 0(sıfır) ise ekrana
yazdırılmayacaktır.
*/

import java.util.Scanner;

public class main {
    public static void main(String[] argv) {
        run.displayDuration();
    }
}

class run{
    public static void displayDuration() {
        long longsaniye;
        System.out.print("saniye değerini giriniz:");
        Scanner scan = new Scanner(System.in);
        longsaniye = scan.nextLong();

        long saniye = longsaniye % 60;
        long longdakika = longsaniye / 60;
        long saat = longdakika / 60;

        System.out.printf("%d:%d:%d",saat,longdakika % 60,saniye);
    }
}
