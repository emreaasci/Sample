package org.csystem.util.math;

public class Fraction {
    private int m_numarator;
    private int m_denominator;

    private static Fraction add(int a1,int b1,int a2, int b2){
        return new Fraction(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Fraction subtract(int a1,int b1,int a2, int b2){
        return add(a1,b1,-a2,b2);
    }

    private static Fraction multiply(int a1,int b1,int a2, int b2){
        return new Fraction(a1 * a2,b1 * b2);
    }

    private static Fraction divide(int a1,int b1,int a2, int b2){
        return multiply(a1,b1,b2,a2);
    }

    private static void check(int numarator,int denominator){
        if(denominator == 0) {
            if (numarator == 0)
                throw new FractionException("Indefinet",FractionExceptionStatus.INDEFINITE,numarator,denominator);

            throw new FractionException("Undefined",FractionExceptionStatus.UNDEFINED,numarator,denominator);


        }
    }

    private void setSign(){
        if(m_denominator < 0){
            m_numarator = -m_numarator;
            m_denominator = -m_denominator;
        }
    }

    private void simplify() {
        int min = Math.min(Math.abs(m_numarator),m_denominator);

        for(int i = min ; i >= 2;i--){
            if(m_numarator % i == 0 && m_denominator % i == 0){
                m_numarator /= i;
                m_denominator /= i;
                break;
            }
        }
    }

    private void set(int a,int b){
        if(a == 0){
            m_numarator = 0;
            m_denominator = 1;
            return;
        }

        m_numarator = a;
        m_denominator = b;

        setSign();

        simplify();
    }

    public Fraction() {
        m_denominator = 1;
    }

    public Fraction(int numarator) {
        m_numarator = numarator;
        m_denominator = 1;

    }

    public Fraction(int numarator, int denominator) {
        check(numarator,denominator);
        set(numarator,denominator);
    }

    public int getNumarator() {
        return m_numarator;
    }

    public void setNumarator(int numarator) {
        if(numarator == m_numarator)
            return;

        set(numarator,m_denominator);
    }

    public int getDenominator() {
        return m_denominator;
    }

    public void setDenominator(int denominator) {
        if(m_denominator == denominator)
            return;

        check(m_numarator,denominator);
        set(m_numarator,denominator);
    }

    public  double getRealValue(){
        return (double) m_numarator / m_denominator;
    }


    //add methods
    public static Fraction add(int val , Fraction other){
        return add(val ,1 ,other.m_numarator,other.m_denominator);
    }

    public Fraction add(Fraction other){
        return add(m_numarator,m_denominator, other.m_numarator, other.m_denominator);
    }

    public Fraction add(int val){
        return add(m_numarator,m_denominator,val,1);
    }

    //subtract methods
    public static Fraction subtract(int val , Fraction other){
        return subtract(val ,1 ,other.m_numarator,other.m_denominator);
    }

    public Fraction subtract(Fraction other){
        return subtract(m_numarator,m_denominator, other.m_numarator, other.m_denominator);
    }

    public Fraction subtract(int val){
        return subtract(m_numarator,m_denominator,val,1);
    }

    //multiply methods
    public static Fraction multiply(int val , Fraction other){
        return multiply(val ,1 ,other.m_numarator,other.m_denominator);
    }

    public Fraction multiply(Fraction other){
        return multiply(m_numarator,m_denominator, other.m_numarator, other.m_denominator);
    }

    public Fraction multiply(int val){
        return multiply(m_numarator,m_denominator,val,1);
    }

    //divide methods
    public static Fraction divide(int val , Fraction other){
        return divide(val ,1 ,other.m_numarator,other.m_denominator);
    }

    public Fraction divide(Fraction other){
        return divide(m_numarator,m_denominator, other.m_numarator, other.m_denominator);
    }

    public Fraction divide(int val){
        return divide(m_numarator,m_denominator,val,1);
    }

    //increment
    public void increment(int val){
        m_numarator += m_denominator * val;
    }

    public void increment(){
        increment(1);
    }

    //decrement
    public void decrement(int val){
        increment(-val);
    }

    public void decrement(){
        decrement(1);
    }

    public String toString (){
        return String.format("%d%s", m_numarator, m_denominator == 1 ?
                "" : String.format(" / %s = %f", m_denominator, getRealValue()));
    }
}
