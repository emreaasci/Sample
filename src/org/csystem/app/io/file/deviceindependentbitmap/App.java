package org.csystem.app.io.file.deviceindependentbitmap;

/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Standart cihaz bağımsız bitmap (Device Independent Bitmap) dosyasında resmin genişliği ve uzunluğu
    dosyanın başından itibaren 18'inci ve 22'inci offsetlerde short bir bilgi olarak tutulmaktadır. Formata göre bu bilgi
    "little endian" olarak yazılmıştır. Bu bilgiyi bir resim dosyasından alıp ekrana yazdıran programı yazınız. Program
    resmin geçerliliği gibi detaylı kontrolleri yapmayacaktır.
----------------------------------------------------------------------------------------------------------------------*/
public class App {
    public static void main(String[] args) {
        DeviceIndependentBitMapApp.run(args);
    }
}
