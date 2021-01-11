package com.example.elevent.utils;

import android.app.Activity;
import android.content.Context;
import android.security.ConfirmationPrompt;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.elevent.R;
import com.example.elevent.ui.game.room.CodeDAO;
import com.example.elevent.ui.game.room.CodeDB;
import com.example.elevent.ui.info.DetailedInfoFragment;
import com.example.elevent.ui.info.DetailedInfoFragmentArgs;
import com.example.elevent.ui.info.InfoFragment;
import com.example.elevent.ui.info.InfoFragmentDirections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.elevent.ui.info.InfoFragmentDirections.*;

public class Utils {

    public static String getStringFromResource(int stringID, Context context) {
        return context.getResources().getString(stringID);
    }

    public static ArrayList<String> getStringArrayAsListFromResource(int stringArrayID, Context context) {
        return new ArrayList<>(Arrays.asList(context.getResources().getStringArray(stringArrayID)));
    }

    public static CharSequence getTextFromResource(int stringID, Context context) {
        return context.getResources().getText(stringID);
    }

    public static void createToast(String text, Context context) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void navigateToNewFragment(Context context, int destinationFragmentID) {
        NavController navController = Navigation.findNavController((FragmentActivity) context, R.id.nav_host_fragment);
        navController.navigate(destinationFragmentID);
    }

    public static void passDataToNewFragment(View view, int infoItemNumber) {
        ShowMoreInfoAction action = InfoFragmentDirections.showMoreInfoAction();
        action.setInfoItemNumber(infoItemNumber);
        Navigation.findNavController(view).navigate(action);
    }

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
