package org.csystem.util.collection;

import java.util.concurrent.atomic.AtomicLongArray;

public class CSDArrayList<E> implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private E [] m_elems;
    private int m_index;

    private static void doWorkForIllegalArgumentException(String message){
        throw new IllegalArgumentException(message);
    }

    private static void doWorkForIndexOutOfboundsException(String message){
        throw new IndexOutOfBoundsException(message);
    }

    private void checkIndex(int index){
        if(index < 0 || index >= m_index)
            doWorkForIndexOutOfboundsException("Index out of bounds");
    }

    private static void checkCapacityValue(int capacity){
        if(capacity < 0)
            doWorkForIllegalArgumentException("Capacity can not be negative");
    }

    private void changeCapacity(int capacity){

        Object [] temp = new Object[capacity];

        System.arraycopy(m_elems,0,temp,0,m_index);  // aşağıdaki forun aynısı

        /*
        for(int i = 0;i < m_index;i++){
            temp[i] = m_elems[i];
        }
        */

        m_elems = (E[]) temp;
    }

    private E remove(int index)
    {
        //TODO:
        E oldVal = m_elems[index];

        return oldVal;
    }



    public CSDArrayList() {
        m_elems = (E [])new Object[DEFAULT_CAPACITY];
    }

    public CSDArrayList(int capacity){
        checkCapacityValue(capacity);
        m_elems = (E[]) new Object[capacity];
    }

    public boolean add(E elem){  // boolean dönmesi gerekiyor.
        if(m_elems.length == m_index)
            changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    //TODO:
    public void add(int index , E elem){

    }

    public E get(int index){
        checkIndex(index);

        return m_elems[index];
    }

    public E set(int index, E elem){
        checkIndex(index);

        E oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public int size(){
        return m_index;
    }

    public int capacity(){
        return m_elems.length;
    }

    public void trimToSize(){
        if(m_index != m_elems.length)
            changeCapacity(m_index);
    }

    public void ensureCapacity(int capacity){

        if(capacity < m_elems.length)
            return;

        changeCapacity(Math.max(capacity,m_elems.length * 2));

        /*
        if(capacity <= m_elems.length * 2)
            changeCapacity(m_elems.length * 2);
        else
           changeCapacity(capacity);
         */
    }

    public void clear(){

        for(int i = 0;i < m_index;i++)
            m_elems[i] = null;

        m_index = 0;
    }

    public Object clone() {
        CSDArrayList<E> ca = new CSDArrayList<>(m_elems.length);

        System.arraycopy(m_elems,0,ca.m_elems,0,m_index);
        ca.m_index = m_index;
        return ca;
    }

    public String toString(){
        String str = "[";

        for (int i = 0; i < m_index; ++i) {
            if (str.length() != 1)
                str += ", ";

            str += m_elems[i];
        }

        return str + "]";
    }


}
