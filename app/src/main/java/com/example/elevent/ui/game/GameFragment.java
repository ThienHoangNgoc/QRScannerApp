package com.example.elevent.ui.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.example.elevent.R;
import com.example.elevent.utils.Utils;

public class GameFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        //Todo: Implement QR Code Lib, use qrCodeItem
        Button scanBtn = root.findViewById(R.id.scan_qr_code_btn);


        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(root.getContext(), R.id.navigation_qr_code_scanner);
            }
        });

        return root;
    }


}
