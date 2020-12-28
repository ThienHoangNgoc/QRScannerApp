package com.example.elevent.utils;

import android.content.Context;

public class Utils {

    public static String getStringFromResource(int stringID, Context context){
        return context.getResources().getString(stringID);
    }


}
