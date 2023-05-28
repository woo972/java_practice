package com.app;

public class SlowClass {
    public void slowMethod(){
        int sum = 0;
        for(int i=0; i<10000; i++){
            sum += i;
        }
    }
}
