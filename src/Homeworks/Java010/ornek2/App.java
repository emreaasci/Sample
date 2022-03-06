package Homeworks.Java010.ornek2;
/* 2. Parametresi ile aldığı int türden bir dizi içerisindeki en çok tekrarlanan sayıyı bulan mod isimli metodu
yazınız.
Not: Metot, dizi içinde en çok tekrarlanan sayı birden fazla ise ilk görülen elamanın değeriyle ile geri dönecektir.      [olmadı]
*/

public class App {
    public static void main(String[] argv){
        int [] a = {5,5,5,6,6,6,7,2,6,10,3,1,3};

        System.out.println(ArrayMod.Mod(a));
    }
}

class ArrayMod {
    public static int Mod(int [] a){
        int modval = 0;
        int mod = 0;

        for(int i = 0;i < a.length;i++){
            int count1 = 0;

            for (int val : a)
                if (val == a[i])
                    count1++;

            if(count1 > mod){
                mod = count1;
                modval = a[i];
            }

            if(count1 == mod){

            }

        }

        return modval;
    }
}