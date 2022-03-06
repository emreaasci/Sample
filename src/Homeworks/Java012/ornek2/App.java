package Homeworks.Java012.ornek2;
/* 2. Parametresi ile aldığı int türden dizi içerisinde tekrarlanan ilk sayıya geri dönen firstRepeated isimli metodu
yazınız.
Not: Metot, dizi içinde tekrarlanan bir sayı yoksa dizinin ilk elemanının değeriyle geri dönecektir
 */

public class App {
    public static void main(String [] argv){
        int [] a = {5,2,1,4,5,6,2,4,6,3,1};

        System.out.println(FirstRepeated.firstRepeated(a));
    }
}

class FirstRepeated {
    public static int firstRepeated(int [] a){

        int firtsRepeated = a[0];

        EXIT_LOOP:
        for(int i = 0;i < a.length - 1;i++){

            for(int k = i + 1;k < a.length;k++)
                if(a[i] == a[k]) {
                    firtsRepeated = a[i];
                    break EXIT_LOOP;
                }
        }

        return firtsRepeated;
    }
}
