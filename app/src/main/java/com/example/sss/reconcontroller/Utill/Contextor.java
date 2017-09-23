package com.example.sss.reconcontroller.Utill;

import android.content.Context;

/**
 * Created by U5713364 on 21/9/2560.
 */

public class Contextor {

    private static Contextor instance;
    private Context context;

    private Contextor () {

    }

    public static Contextor getInstance() {
        if (instance == null) {
            instance = new Contextor();
        }
        return instance;
    }

    public void init (Context context) {
        this.context = context;
    }

    public Context getContext(){
        return context;
    }

    public static void clear(){
        instance = null;
    }

}
