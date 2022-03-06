package Homeworks.java015.ornek1;

import java.util.Random;

public class Card {
    private CardValue m_value;
    private CardType m_type;
    private final static CardValue [] m_cardValues = CardValue.values();
    private final static CardType [] m_cardTypes = CardType.values();
    private static Random r;

    //...

    public Card(CardType type,CardValue value){
        m_value = value;
        m_type = type;
        r = new Random();
        //...
    }

    public Card(String name){
        r = new Random();
        setName(name);

    }
    public String getName(){

        return m_type.toString()+ " " + m_value.toString();
    }

    public void setName(String name){
        String [] infos = name.split("[-]");
        String type = infos[0];
        String value = infos[1];

        for(int i = 0;i < m_cardTypes.length;i++){
            CardType t = m_cardTypes[i];
            if(t.getType().equals(type)) {
                m_type = t;
                break;
            }
        }

        for(int i = 0;i < m_cardValues.length;i++){
            CardValue v = m_cardValues[i];
            if(v.getValue().equals(value)){
                m_value = v;
                break;
            }
        }
    }
    //...

    public String toString(){

        return m_type.getType() + " " + m_value.getValue();
    }

    public static Card[] getDeck() {
        Card[] deck = new Card[52];
        for(int i = 0;i < deck.length;)
            for(int k = 0;k < m_cardTypes.length;k++)
                for(int j = 0;j < m_cardValues.length;j++){
                    deck[i] = new Card(m_cardTypes[k],m_cardValues[j]);
                    i++;
                }
        return deck;
    }

    public static Card[] getShuffledDeck(){

        Card [] deck = getDeck();
        int mixval = r.nextInt(100- 50) + 50;

        for(int i = 0;i < mixval;i++){
            int first = r.nextInt(deck.length);
            int second = r.nextInt(deck.length);

            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }

        System.out.printf("Karıştırılma Sayısı: %d%n",mixval);

        return deck;
    }
    //...
}

/* Soru: Bir oyun kartını temsil eden Card isimli sınıfı aşağıda belirtildiği gibi org.csystem.games.cardgames
paketi içerisinde yazınız:
Bir kartın iki özelliği vardır: türü ve değeri. Bunun için aşağıdaki enum türlerini kullanabilirsiniz:

package org.csystem.games.cardgames;
public enum CardType
    {
        SPADE, CLUB, DIAMOND, HEART
    }

package org.csystem.games.cardgames;
public enum CardValue
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, KNAVE, QUEEN, KING, ACE
    }
Bu iki özellik Card sınıfının private veri elemanlarıyla ifade edilebilir:

package org.csystem.games.cardgames;
public class Card
{
    private CardValue m_value;
    private CardType m_type;
    //...
    public Card(CardValue value, CardType type)
    {
        //...
    }
    public Card(String name)
    {
        //...
    }
    public String getName()
    {
        //...
    }
    public void setName(String name)
    {
        //...
    }
    //...
    public String toString()
    {
        //...
    }
    public static Card[] getShuffledDeck()
    {
        Card[] deck = new Card[52];
        //...
        return deck;
    }
    //…
}

Card sınıfına başlangıç, get ve set metotları yerleştirilmelidir. Ayrıca Card sınıfının aşağıdaki parametrik yapıya
sahip bir toString() metodu bulunmalıdır.

public String toString()
{
    //...
}

Bir kart nesnesinin yaratılması ve yazdırılması şöyle yapılabilir:

Card c = new Card(CardValue.ACE, CardType.DIAMOND); // Karo As
System.out.println(c.toString());

Bu başlangıç metodunun iki tane enum türünden argüman aldığına dikkat ediniz. Ayrıca sınıfa String parametreli
bir başlangıç metodu yerleştiriniz. Bu metot kartı sayıyla değil yazıyla alıp oluşturmalıdır. Örneğin:

Card c = new Card(“Kupa-Papaz”);
Sınıfın ayrıca getName ve setName metotları da bulunmalıdır.
c.setName(“Kupa-Papaz”);

Kart isimlerinin, önce tür sonra değeri ile belirtildiğine ve arada ‘-‘ karakterinin bulunduğuna dikkat ediniz.
setName metodu yazıyı ayrıştırarak sınıfın m_type ve m_value veri elemanlarını set edecektir. Geçeriz yazı için
programı mesaj verip sonlandırabilirsiniz.

Sınıfın static getShuffledDeck isimli metodu bize karıştırılmış bir deste (52 tane) kart verir. Karıştırma için
dizinin iki elemanını belli miktarda yer değiştirebilirsiniz. Test işlemini aşağıdaki örnek kodla yapabilirsiniz:

public static void main(String [] args)
{
    Card[] deck;
    deck = Card.getShuffledDeck();
    for (Card c : deck)
    System.out.println(c.toString());
}

Card sınıfına ve enum türlerine istediğiniz başka elemanları ekleyebilirsiniz.


                MAIN METODU

package org.csystem.app;

import Homeworks.java015.ornek1.Card;
import Homeworks.java015.ornek1.CardType;
import Homeworks.java015.ornek1.CardValue;

class App {
    public static void main(String[] args)
    {
        Card card = new Card(CardType.DIAMOND,CardValue.ACE);
        System.out.println(card.toString());
        System.out.println(card.getName());

        System.out.println("-----------------");

        Card card1 = new Card("Maça-Vale");
        System.out.println(card1.toString());
        System.out.println(card1.getName());

        System.out.println("-----------------");

        card1.setName("Karo-Kız");
        System.out.println(card1.toString());
        System.out.println(card1.getName());

        System.out.println("-----------------");


        Card[] deck;
        deck = Card.getShuffledDeck();
        for (Card c : deck)
            System.out.println(c.toString());
    }
}

 */
