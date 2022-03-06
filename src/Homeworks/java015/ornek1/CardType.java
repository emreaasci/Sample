package Homeworks.java015.ornek1;

public enum CardType {
    SPADE("Maça"), CLUB("Sinek"), DIAMOND("Karo"), HEART("Kupa");
    private String m_type;

    private CardType(String type){
        m_type = type;
    }

    public String getType() {
        return m_type;
    }
}
