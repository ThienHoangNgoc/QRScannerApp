package com.example.elevent.ui.game;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.elevent.R;
import com.example.elevent.utils.Utils;
import com.google.zxing.Result;

import java.util.Map;


public class QrCodeScannerFragment extends Fragment {

    private final int CAMERA_REQUEST_CODE = 101;
    private CodeScanner codeScanner;
    private final String TAG = "QRCODESCANNER";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Activity activity = getActivity();
        View root = inflater.inflate(R.layout.fragment_qr_code_scanner, container, false);
        CodeScannerView codeScannerView = root.findViewById(R.id.code_scanner_view);
        TextView output = root.findViewById(R.id.output_text);
        codeScanner = new CodeScanner(activity, codeScannerView);
        setupPermissions();
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        output.setText(result.getText());
                    }
                });
            }
        });
        return root;
    }

    private void setupPermissions() {
        int permission = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest();
        } else {
            codeScanner.startPreview();
        }
    }


    private void makeRequest() {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
    }


    public void showCodeScannerPreview() {
        codeScanner.startPreview();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }
}
