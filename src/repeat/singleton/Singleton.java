package repeat.singleton;
/*--------------------------------------------------------------------------------------------------------------------
    Singleton: Öyle bir sınıf olsun ki bu sınıf türünden program boyunca yalnızca bir tane nesne yaratılabilsin ve
    istendiğinde bu nesnenin referansına erişilebilsin.

    Anahtar Notlar: Singleton kalıbının bir çok "gerçekleştirimi (implementation)" yapılır
---------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------
    Singleton kalıbının bir implementasyonu (lazy implementation)
---------------------------------------------------------------------------------------------------------------------*/

public class Singleton {
    private static Singleton ms_instance;
    private int m_x;
    //...

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(ms_instance == null)
            ms_instance = new Singleton();

        return ms_instance;
    }

    public void setX(int x){
        //...
        m_x = x;
    }

    public int getX(){
        //...
        return m_x;
    }

    //...

}
