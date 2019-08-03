package com.example.cabeloni.epcomp;

import android.support.v7.app.AppCompatActivity;

public class global extends AppCompatActivity {

    private static int counter=0;

    public static int getc() {
        return counter;
    }

    public static void setc(int counter2) {
        counter = counter2;
    }
}