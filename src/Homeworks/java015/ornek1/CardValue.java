package Homeworks.java015.ornek1;

public enum CardValue {
    TWO("İki"), THREE("Üç"), FOUR("Dört"), FIVE("Beş"), SIX("Altı"), SEVEN("Yedi"), EIGHT("Sekiz"),
    NINE("Dokuz"), TEN("On"), KNAVE("Vale"), QUEEN("Kız"), KING("Papaz"), ACE("As");

    private String m_value;

    private CardValue(String value){
        m_value = value;
    }

    public String getValue() {
        return m_value;
    }


}
