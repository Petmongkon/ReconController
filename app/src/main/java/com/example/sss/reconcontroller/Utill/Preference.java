package com.example.sss.reconcontroller.Utill;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by U5713364 on 21/9/2560.
 */

public class Preference {

    public static Preference preference=null;

    public Preference(){

    }
    public static Preference getInstance(){
        if(preference == null){
            preference = new Preference();
        }
        return preference;
    }

    public void Save(String key,String value){
        SharedPreferences sp =Contextor.getInstance().getContext().getSharedPreferences(Constant.PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public String  Get(String key){
        SharedPreferences sp =Contextor.getInstance().getContext().getSharedPreferences(Constant.PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
