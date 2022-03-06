package Homeworks.Java004.ornek1;

/* Soru: Klavyeden girilen tamsayı değerlerin, toplam sayısını, en büyüğünü, en küçüğünü ve ortalamasını hesaplayan
programı yazınız. Kullanıcının her değer girişinden önce, yeni bir değer girmek isteyip istemediği aşağıdaki gibi
sorulacaktır:
Yeni bir deger girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]
Kullanıcı 1(bir) sayısını girerse, program kullanıcının bir değer girmesini isteyecektir.
Bir tamsayı giriniz: 53 enter
Kullanıcı 0(sıfır) sayısını girerse, program o ana kadar girilen değerlerle ilgili olarak aşağıdaki dökümü ekran çıktısı
olarak vererek sonlanacaktır:

Toplam 17 deger girildi.
Max = 89
Min = 17
Ortalama = 37.456786
program sonlandı.

1. Kaynak programda dizi kullanılmayacaktır.
2. Girilen değerler [0 - 100] aralığında olmalıdır. Geçersiz bir değer girilmesi sırasında ekrana
"geçersiz değer "
uyarısı yazılacak ve yeni bir giriş yapılması istenecektir:
"yeni bir deger giriniz"
*/

public class main {
    public static void main(String[] argv) {
        NumberUtil.app();
    }
}

class NumberUtil{
    public static void app() {
        java.util.Scanner scan = new java.util.Scanner(System.in);

        int sum = 0,count = 0;
        int max = 0,min = 2_147_483_647;
        int val1 = 0,val2 = 0;

        for(;;) {

            System.out.print("Yeni bir deger girmek istiyor musunuz? [Evet için 1(bir), Hayır için 0(sıfır) değerlerinden birini giriniz]");
            int cont = Integer.parseInt(scan.nextLine());


            if (cont == 0)
                break;

            else if (cont == 1) {
                System.out.print("bir tamsayı giriniz:");
                val1 = Integer.parseInt(scan.nextLine());
                sum += val1;
                count++;

                if (val1 >= max)
                    max = val1;

                if(val1 <= min)
                    min = val1;

                val2 = val1;

            }

        }

        System.out.printf("Toplam %d değer girildi.%n", count);
        System.out.printf("Max = %d%n", max);
        System.out.printf("Min = %d%n", min);
        System.out.printf("Ortalama = %.2f%n", (double)sum / count);

    }

}