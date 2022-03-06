package Homeworks.Java009.ornek2;
/* 2. Parametresi ile aldığı int türden bir dizinin en büyük ikinci elemanını bulan secondMax isimli metodu yazınız.
Denemeyi bir diziye ilk değer vererek yapabilirsiniz.
*/

public class App {
    public static void main(String[] argv){
        int [] a = {10,52,15,34,62,71,78};

        System.out.println(SecondMAX.secondIndex(a));

    }
}

class SecondMAX {
    public static int secondIndex(int [] a){
        int max = 0;
        int maxindex = maxIndex(a);
        for(int i = 0;i < a.length;i++){
            if(i == maxindex)
                continue;

            if(a[i] > max)
                max = a[i];
        }

        return max;
    }

    public static int maxIndex(int [] a){
        int max = a[0];
        int maxindex = 0;
        for(int i =0; i < a.length;i++){
            if(a[i] > max) {
                max = a[i];
                maxindex = i;
            }
        }

        return maxindex;
    }
}
