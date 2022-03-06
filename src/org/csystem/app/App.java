/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnek geçerlidir. super.foo() çağrısında B sınfının foo metodu çağrılır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;
class Dugum{
    public int veri;
    public Dugum kuyruk;
    public Dugum(){
        kuyruk = null;
    }
    public void yazdir(){
        System.out.print( + veri + " ");
    }
}
class Bliste{
    private Dugum ilk,son;
    public Bliste(){
        ilk = null;
        son = null;
    }
    public void basaEkle(int data){
        Dugum yeni = new Dugum();
        yeni.veri = data;
        if (ilk == null){
            son = yeni;
        }
        yeni.kuyruk = ilk;
        ilk = yeni;
    }
    public void sonaEkle(int data) {
        Dugum yeni = new Dugum();
        yeni.veri = data;
        yeni.kuyruk = null;
        if (ilk == null) {
            ilk = yeni;
            son = yeni;
        }
        else {
            son.kuyruk = yeni;  //sıkıntı
            son = yeni;
        }
    }
    public Dugum bul(int anahtar){
        Dugum etkin = ilk;

        while(etkin.veri != anahtar){
            if(etkin.kuyruk == null)
                return null;
            else
                etkin = etkin.kuyruk;
        }
        return etkin;
    }
    public Dugum sil(int anahtar){
        Dugum etkin = ilk;  // silinmek istenen dugum
        Dugum onceki = ilk;

        while(etkin.veri != anahtar){
            if(etkin.kuyruk == null)
                return null;
            else{
                onceki = etkin;
                etkin = etkin.kuyruk;
            }
        }
        if(etkin == ilk)
            ilk = ilk.kuyruk;

        else
            onceki.kuyruk = etkin.kuyruk;

        return etkin;
    }
    public void listele(){
        System.out.print("\nBaştan sona listeleme:");
        Dugum etkin = new Dugum();
        etkin = ilk;
        while(etkin != null){
            etkin.yazdir();
            etkin = etkin.kuyruk;
        }

    }
}

class App {
    public static void main(String [] args)
    {
        Bliste liste = new Bliste();
        liste.basaEkle(5000);

        liste.sonaEkle(20);
        liste.sonaEkle(30);
        liste.sonaEkle(40);
        Dugum d = liste.bul(30);
        liste.listele();
        System.out.println();
        d.yazdir();
        liste.sil(30);
        liste.listele();
    }
}

