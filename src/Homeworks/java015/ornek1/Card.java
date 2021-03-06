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

        System.out.printf("Kar????t??r??lma Say??s??: %d%n",mixval);

        return deck;
    }
    //...
}

/* Soru: Bir oyun kart??n?? temsil eden Card isimli s??n??f?? a??a????da belirtildi??i gibi org.csystem.games.cardgames
paketi i??erisinde yaz??n??z:
Bir kart??n iki ??zelli??i vard??r: t??r?? ve de??eri. Bunun i??in a??a????daki enum t??rlerini kullanabilirsiniz:

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
Bu iki ??zellik Card s??n??f??n??n private veri elemanlar??yla ifade edilebilir:

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
    //???
}

Card s??n??f??na ba??lang????, get ve set metotlar?? yerle??tirilmelidir. Ayr??ca Card s??n??f??n??n a??a????daki parametrik yap??ya
sahip bir toString() metodu bulunmal??d??r.

public String toString()
{
    //...
}

Bir kart nesnesinin yarat??lmas?? ve yazd??r??lmas?? ????yle yap??labilir:

Card c = new Card(CardValue.ACE, CardType.DIAMOND); // Karo As
System.out.println(c.toString());

Bu ba??lang???? metodunun iki tane enum t??r??nden arg??man ald??????na dikkat ediniz. Ayr??ca s??n??fa String parametreli
bir ba??lang???? metodu yerle??tiriniz. Bu metot kart?? say??yla de??il yaz??yla al??p olu??turmal??d??r. ??rne??in:

Card c = new Card(???Kupa-Papaz???);
S??n??f??n ayr??ca getName ve setName metotlar?? da bulunmal??d??r.
c.setName(???Kupa-Papaz???);

Kart isimlerinin, ??nce t??r sonra de??eri ile belirtildi??ine ve arada ???-??? karakterinin bulundu??una dikkat ediniz.
setName metodu yaz??y?? ayr????t??rarak s??n??f??n m_type ve m_value veri elemanlar??n?? set edecektir. Ge??eriz yaz?? i??in
program?? mesaj verip sonland??rabilirsiniz.

S??n??f??n static getShuffledDeck isimli metodu bize kar????t??r??lm???? bir deste (52 tane) kart verir. Kar????t??rma i??in
dizinin iki eleman??n?? belli miktarda yer de??i??tirebilirsiniz. Test i??lemini a??a????daki ??rnek kodla yapabilirsiniz:

public static void main(String [] args)
{
    Card[] deck;
    deck = Card.getShuffledDeck();
    for (Card c : deck)
    System.out.println(c.toString());
}

Card s??n??f??na ve enum t??rlerine istedi??iniz ba??ka elemanlar?? ekleyebilirsiniz.


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

        Card card1 = new Card("Ma??a-Vale");
        System.out.println(card1.toString());
        System.out.println(card1.getName());

        System.out.println("-----------------");

        card1.setName("Karo-K??z");
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
