package com.drools.wypozyczalnia;

public class Mutex {
    int val;
    public Mutex(){
        val = 0;
    }

    public void lock(){
        val = 1;
    }

    public void unlock(){
        val = 0;
    }

    public int getVal(){
        return val;
    }
}
