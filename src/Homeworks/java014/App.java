package Homeworks.java014;
/* Soru: Doldurulmuş bir Sudoku’nun geçerli olup olmadığını belirleyen programı yazınız.
Açıklama:
Sudoku oyunu Sudoku isimli bir sınıfla temsil edilecektir. Sınıfın 9X9’luk bir matris veri elemanı vardır.
Başlangıç metodu bu matrisi tahsis eder, read metodu klavyeden sayıları okuyarak matrise yerleştirir. Sınıfın
static olmayan isValid metodu da geçerlilik testini yapmaktadır. Örneğin:

package org.csystem.games.sudoku;
public class Sudoku {
    private int[][] m_sdm;
    public Sudoku(){
    m_sdm = new int[9][9];
    }
    public void read(){
    // Klavyeden okuma yap ve matrise yerleştir
    }
    public boolean isValid(){
    //...
    }
    //...
}
- Sınıfa gerekli metotları ekleyebilirsiniz. Test işlemini şöyle bir programla yapabilirsiniz:
package org.csystem.games.sudoku;
class App{
    public static void main(String [] args){
    Sudoku sd = new Sudoku();
    sd.read();
    if (sd.isValid())
        System.out.println(“Geçerli”);
    else
        System.out.println(“Geçerli değil”);
    }
}

- Geçerli Sudoku sayılarını bir dosyaya yazıp bunu okuma sırasında kopyala-yapıştır yapabilirsiniz. Sayıları tek
tek elle girmeye çalışmayınız...
*/

public class App {
    public static void main(String[] argv){

    }
}


