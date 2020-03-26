package com.example.laba1;

import android.content.Context;
import android.content.Intent;

import java.util.concurrent.TimeUnit;

public class ThreadHandler {
    private static ThreadHandler instance;
    public ThreadHandler(Thread thread) {
        thread.start();
    }
    public static ThreadHandler createInstance(Thread thread) {
        if(instance == null) {
            instance = new ThreadHandler(thread);
            return instance;
        } else {
            return instance;
        }
    }
}
