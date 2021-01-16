package com.example.qrcodescannerevent.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.qrcodescannerevent.R;
import com.example.qrcodescannerevent.ui.game.room.CodeDAO;
import com.example.qrcodescannerevent.ui.game.room.CodeDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Utils {

    //get string from your resource folder (res/string)
    public static String getStringFromResource(int stringID, Context context) {
        return context.getResources().getString(stringID);
    }
    //get string-array from your resource folder (res/string)
    public static ArrayList<String> getStringArrayAsListFromResource(int stringArrayID, Context context) {
        return new ArrayList<>(Arrays.asList(context.getResources().getStringArray(stringArrayID)));
    }

    //create a toast
    public static void createToast(String text, Context context) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    //this method uses the NavController to navigate through fragments
    //nav component is used in this app for navigation
    public static void navigateToNewFragment(Context context, int destinationFragmentID) {
        NavController navController = Navigation.findNavController((FragmentActivity) context, R.id.nav_host_fragment);
        navController.navigate(destinationFragmentID);
    }

    /**
     * use this method to get your DAO object for further operations with the room db
     * @param context
     * @return
     */
    public static CodeDAO getCodeDAO(Context context) {
        return CodeDB.getCodeDB(context).getItemDAO();
    }

    /**
     *
     * @param list a String ArrayList
     * @return return the shuffled list
     */
    public static ArrayList<String> randomOrderGenerator(ArrayList<String> list) {
        Collections.shuffle(list);
        return list;
    }


}
