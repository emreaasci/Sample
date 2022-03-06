package org.csystem.util;

public final class Pair<F,S> {
    private F m_first;
    private S m_second;

    public static <F,S> Pair <F,S> of(F first,S second){
        return new Pair<>(first, second);
    }

    public Pair(F first, S second) {
        m_first = first;
        m_second = second;
    }

    public F getFirst() {
        return m_first;
    }

    public S getSecond() {
        return m_second;
    }

    public String toString(){
        return String.format("{first: %s , second: %s}",m_first,m_second);

    }
}
