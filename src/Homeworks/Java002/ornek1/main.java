package Homeworks.Java002.ornek1;
import java.util.Scanner;

/* 1. Klavyeden bir n sayısı okuyunuz ve aşağıdaki deseni oluşturan programı yazınız (örneğimizde n = 6’dır):

                *
               ***
              *****
             *******
            *********
           ***********
            *********
             *******
              *****
               ***
                *

 */
public class main {
    public static void main(String[] argv) {
        int satır =  ucgen.getnumber();
        ucgen.ucgen1(satır);
    }
}

class ucgen{
    public static int getnumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("bir sayi giriniz:");
        int satır = scan.nextInt();

        return satır;
    }

    public static void ucgen1(int satır) {
        int yıldız = 1;
        int bosluk = satır-1;

        for(int i = 0;i<satır;i++) {
            for(int a=0;a<bosluk;a++) {
                System.out.print(" ");
            }
            for(int b=0;b<yıldız;b++) {
                System.out.print("*");
            }
            System.out.println();
            bosluk -= 1;
            yıldız += 2;
        }
        yıldız = 2*satır-3;
        bosluk = 1;
        for(int i=0;i<satır-1;i++) {
            for(int a=0;a<bosluk;a++){
                System.out.print(" ");
            }
            for(int b=0;b<yıldız;b++) {
                System.out.print("*");
            }
            System.out.println();
            bosluk++;
            yıldız -= 2;

        }
    }

}
