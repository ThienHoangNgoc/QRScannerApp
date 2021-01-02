package com.example.elevent.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static String getStringFromResource(int stringID, Context context) {
        return context.getResources().getString(stringID);
    }

    public static void createToast(String text, Context context) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }


}
