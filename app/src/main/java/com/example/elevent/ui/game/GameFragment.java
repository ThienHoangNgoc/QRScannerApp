package com.example.elevent.ui.game;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elevent.R;
import com.example.elevent.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GameFragment extends Fragment {

    List<QrCodeItem> dataSet = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        //Todo: use RoomDB, create RNG order for questions, alertdialog
        Button scanBtn = root.findViewById(R.id.scan_qr_code_btn);
        TextView textView = root.findViewById(R.id.game_progress_text);


        textView.setText(getProgressionText(root.getContext()));
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(root.getContext(), R.id.navigation_qr_code_scanner);
            }
        });

        return root;
    }

    private void setupItems() {
        //Todo: Database
    }


    private CharSequence getProgressionText(Context context) {
        String progressionText = Utils.getStringFromResource(R.string.game_progress_text_01, context) +
                " <b>" +
                Utils.getStringFromResource(R.string.game_progress_text_02, context).replace("X", "" + getNumberOfRightAnswers()) + "</b> " +
                Utils.getStringFromResource(R.string.game_progress_text_03, context);

        return Html.fromHtml(progressionText);
    }

    private int getNumberOfRightAnswers() {
        //Todo: implement this
        return 0;
    }


}
