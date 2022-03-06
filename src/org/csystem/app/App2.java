package org.csystem.app;

class MyArray{
    private int[] array;
    private int kapasite = 100;
    private int index;
    public MyArray(){
        array = new int[kapasite];
        index = 0;
    }

    public int push(int val){
        if(dolumu())
            return -1;

        array[index] = val;
        index++;

        return 0;
    }

    public int pop(){
        if(bosmu())
            return -1;

        int val = array[index - 1];
        index--;


        return val;

    }

    public int top(){
        if(bosmu())
            return -1;

        return array[index - 1];
    }

    public boolean bosmu(){
        if(index == 0)
            return true;

        return false;
    }

    public boolean dolumu(){
        if(index == kapasite - 1)
            return true;

        return false;
    }



}

public class App2 {
    public static void main(String[] args) {

    }
}
