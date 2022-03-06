package org.csystem.app.io.file.randomaccsess;

/*----------------------------------------------------------------------------------------------------------------------
    RandomAccessFile Sınıfı
    RandomAccessFile sınıfı ile dosya üzerinde istenilen offset’e konumlanma yapılarak yazma ya da okuma yapılabilir.
    RandomAccessFile sınıfı ile dosyanın açılış moduna göre okuma veya hem okuma hem yazma yapılabilir. RandomAccessFile
    Object sınıfından türetilmiştir. Closeable arayüzünü ve diğer bazı okuma ve yazmaya ilişkin arayüzleri
    desteklemektedir. Sınfın write ve writeXXX metotları ile yazma işlemi yapılabilir. read ve readXXX metotları ile de
    okuma yapılabilir. Sınıfın iki adet başlangıç metodu bulunmaktadır. Başlangıç metotlarının birinci parametreleri
    dosyaya ilişkin yol ifadesi ya da File referansıdır. Başlangıç metotlarının ikinci parametreleri ortaktır. Bu parametreler
    dosyanın açılış modunu belirlemek için kullanılır. Açılış modları “r”, “rw”, “rws”, “rwd” biçiminde olabilir.
    Bunlar dışındaki değerler exception oluşmasına yol açar:
    “r”     → Yalnızca okuma amaçlı açmak için kullanılır. Dosya yoksa exception oluşur.
    “rw”    → Hem okuma hem de yazma amaçlı kullanılan moddur. Dosya yoksa yaratılır.
    “rws” ve “rwd” açılış modları “New IO” mekanizmasına ilişkindir. Burada ele alınmayacaktır

    RandomAccessFile sınıfı dosyayı her zaman korur. RandomAccessFile sınıfı ile dosya açıldığında dosya göstericisi
    sıfır numaralı offet'i gösterir.

    Dosya Göstericisinin Konumlandırılması
    Sınfın seek metodu ile istenilen bir offsete konumlanılabilir. Sınıfın getFilePointer metodu ile o anki dosya
    göstericisinin nerede olduğu bilgisi alınabilir.
----------------------------------------------------------------------------------------------------------------------*/

public class App {
    public static void main(String[] args) {
        RandomAccessFileStandardInputApp.run(args);
    }
}
