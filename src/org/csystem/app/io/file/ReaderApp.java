/*----------------------------------------------------------------------------------------------------------------------
    FileInputStream sınıfının byte dizi parametreli read metotları byte türden dizinin içerisine dosyadaki bilgileri
    okur. Yani dosyaya yazar. Ne kadar okuduğu miktarı ile de geri döner. Bu durumda programcının ne kadar okunduğu
    miktarına göre dizinin elemanlarını kullanması gerekir. Yani aslında dizinin uzunluğu ya da okumak için verilen sayı
    en fazla ne kadar okunacağını belirtir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.io.file;

import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

final class ReaderApp {
    private ReaderApp()
    {
    }
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argümanlar");
            System.exit(-1);
        }

        try(FileInputStream fis =  new FileInputStream(args[0])){

            DataInputStream dis =  new DataInputStream(fis);
            for(;;){
                String text = dis.readUTF();

                System.out.println(text);
            }

        }
        catch (EOFException ignore){
            System.out.printf("Okuma tamamlandı");
        }
        catch (NumberFormatException ignore) {
            System.err.println("Geçersiz blok uzunluğu");
        }
        catch (FileNotFoundException ignore) {
            System.err.println("Dosya bulunamadı");
        }
        catch (Throwable ex) {
            System.err.printf("Exception:%s", ex.getMessage());
        }
    }
}