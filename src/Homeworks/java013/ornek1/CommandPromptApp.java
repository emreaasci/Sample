package Homeworks.java013.ornek1;

/* Soru: Komut satırı oluşturup komut yorumlayan aşağıdaki uygulamayı yazınız:
        Açıklamalar:
        - Program CSD ismiyle bir imleç oluşturmaktadır:
        CSD>
        - Komutları iki tırnak içerisinde bir yazı izlemektedir. İki tırnak kontrolü yapılmalıdır. Komuttan önce, komuttan
        sonra boşluk karakterleri bulunabilir:
        length "yazı"
        reverse "yazı"
        upper "yazı"
        lower "yazı"
        quit
        length yazının uzunluğunu yazdırır. reverse yazıyı tersten yazdırır. upper yazıyı büyük harf olarak, lower küçük
        harf olarak yazdırır. quit programdan çıkmakta kullanılır.
        - Komutun ilk üç karakteri zorunludur, diğer karakterleri isteğe bağlıdır. Örneğin aşağıdaki komutlar geçerlidir:
        len, leng, lengt, length
        Aşağıdaki komutlar geçersizdir:
        lenx, lenxx, lengxxx
 */


public class CommandPromptApp {
    private CommandPromptApp(){

    }

    public static void run() {
        CommandPrompt cmd1 = new CommandPrompt("CTDS");

        CommandPrompt.run();
    }
}
