package Homeworks.Java012.ornek1;
/* 1. Parametresi ile aldığı bir dizinin standart sapmasını bulan standardDeviation isimli metodu yazınız ve
elemanları rasgele üretilmiş diziler ile test ediniz

Standart sapma hesaplarken;
1- Öncelikle veri setine bakılır. Örneğin; bir sınavın sonuçları 10, 8, 10, 8, 8 ve 4 şeklinde olsun.
2- Veri setindeki bütün sayıların aritmetik ortalaması hesaplanır. Aritmetik ortalama bir setteki bütün değerlerin toplamının
terim sayısına bölünmesiyle bulunur. Bu durumda;
Aritmetik Ortalama = 10+8+10+8+8+4 = 48
48/6(terim sayısı) = 8 olarak hesaplanır.
3- Daha sonra veri setindeki varyansın bulunması gerekir. Varyans, bilgilerin aritmetik ortalama etrafında nasıl kümelendiğini gösterir
ve genelde iki veri setini karşılaştırmada kullanılır. Varyansı bulmak için veri setindeki bütün sayılardan aritmetik ortalama çıkarılır.
Daha sonra sonucun karesi alınır.
10-8 = 2, 2² = 4
8-8 = 0, 0² = 0
10-8 = 2, 2² = 4
8-8 = 0, 0² = 0
8-8 = 0, 0² = 0
4-8 = -4, (-4)² = 16
4- Daha sonra karesi alınan sayılar toplanır. 4+0+4+0+0+16 = 24.
5- Karelerin toplamı n-1'e bölünür. 24/(6-1)=4,8
6- Standart sapma için varyansın karekökü alınır. 4,8'in karekökü 2,19'dur.
 */

import org.csystem.util.ArrayUtil;
import org.csystem.util.NumberUtil;

public class App {
    public static void main(String [] argv){
        int [] a = {10,8,10,8,8,4};

        System.out.println(StandardDeviation.standardDeviation(a));
    }
}


class StandardDeviation {
    public static double standardDeviation(int [] a){
        double arithmeticMean = (double)ArrayUtil.sum(a) / a.length;
        double variance = 0;

        for(int val : a)
            variance += Math.pow(val - arithmeticMean, 2);

        variance = Math.sqrt(variance / (a.length - 1));

        return variance;
    }
}
