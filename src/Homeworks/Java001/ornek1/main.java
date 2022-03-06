package Homeworks.Java001.ornek1;/* 1. Klavyeden alınan int türden üç sayı arasındaki büyüklük-küçüklük ilişkisini küçükten büyüğe doğru < ve =
sembolleriyle gösteriniz:
Açıklama : Program üç tane int türden sayı isteyecek, aralarındaki ilişkiyi ekranda gösterecek. İşte birkaç örnek :
Giriş: 10 20 30
Yanıt: 10 < 20 < 30
Giriş: 30 10 20
Yanıt: 10 < 20 < 30
Giriş: 10 10 15
Yanıt: 10 = 10 < 15
Giriş: 40 50 50
Yanıt: 40 < 50 = 50
2. Parametresi ile aldığı int türden 3 sayıdan ortancasına geri dönen mid isimli metodu yazınız ve test ediniz.
3. Parametresi ile aldığı int türden bir sayının negatif mi, 0(sıfır) mı, pozitif mi olduğunu test eden signum isimli
metodu yazınız ve test ediniz. Metot pozitif için 1(bir), negatif için -1(eksi bir) ve sıfır için 0(sıfır) döndürecektir
*/

import java.util.Scanner;

public class main {
	public static void main(String[] argv) {
		NumberUtil.run();
	}
}

class NumberUtil {
	public static void run() {
		int a,b,c;
		Scanner scan = new Scanner(System.in);
		System.out.print("1.sayi:");
		a = scan.nextInt();
		System.out.print("2.sayi:");
		b = scan.nextInt();
		System.out.print("3.sayi:");
		c = scan.nextInt();
		
		sırala(a,b,c);
		int middle = mid.middle(a, b, c);
		System.out.printf("%d%n",middle);
		int pozitif = pozitifmi.signum(a);
		System.out.printf("%d",pozitif);
		
	}

	public static void sırala(int a,int b,int c) {
		int max,min,mid;
		max = Math.max(Math.max(a, b), c);
		min = Math.min(Math.min(a, b), c);
		mid = a + b + c - max - min;
		
		if(max==mid) {
			System.out.printf("%d<%d<=%d%n",min,mid,max);
		}
		else if(mid==min) {
			System.out.printf("%d<=%d<%d%n",min,mid,max);
		}
		else {
			System.out.printf("%d<%d<%d%n",min,mid,max);
		}
	}
}

class mid {
	public static int middle(int a,int b,int c) {
		int max,min,mid;
		max = Math.max(Math.max(a, b), c);
		min = Math.min(Math.min(a, b), c);
		mid = a + b + c - max - min;
		
		return mid;
	}
}

class pozitifmi{
	public static int signum(int a) {
		if(a<0) {
			return -1;
		}

		else if(a>0) {
			return 1;
		}
		
		return 0;
	}
}