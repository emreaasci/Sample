package org.csystem.util.math;

import com.sun.source.tree.ReturnTree;

import java.util.concurrent.RecursiveTask;

public class FractionException extends NumberFormatException{
    private final FractionExceptionStatus m_status;
    private final int m_a;
    private final int m_b;

    public FractionException(String s, FractionExceptionStatus status, int a, int b) {
        super(s);
        m_status = status;
        m_a = a;
        m_b = b;
    }

    public FractionExceptionStatus getStatus() {
        return m_status;
    }

    public int getNumarator() {
        return m_a;
    }

    public int getDenominator() {
        return m_b;
    }

    public String getMessage(){
        return String.format("Message:%s, STATUS: %s, Numarator:%d, Denominator: %d",super.getMessage(),m_status.toString(),m_a,m_b);
    }


}
