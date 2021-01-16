package com.example.qrcodescannerevent.ui.game;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.qrcodescannerevent.R;
import com.google.zxing.Result;


public class QrCodeScannerFragment extends Fragment {

    private final int CAMERA_REQUEST_CODE = 101;
    private CodeScanner codeScanner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Activity activity = getActivity();
        View root = inflater.inflate(R.layout.fragment_qr_code_scanner, container, false);
        CodeScannerView codeScannerView = root.findViewById(R.id.code_scanner_view);
        codeScanner = new CodeScanner(activity, codeScannerView);
        setupPermissions();
        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //if the scan was successful put the result into safe arg bundle to use it in the directed fragment (GameFragment)
                        //this is used to pass data to the new fragment, which is navigated to
                        QrCodeScannerFragmentDirections.OpenDialogAction action = QrCodeScannerFragmentDirections.openDialogAction();
                        action.setQrCode(result.getText());
                        Navigation.findNavController(root).navigate(action);
                    }
                });
            }
        });
        return root;
    }

    //get permission for the camera
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

    //this is used in the main activity
    public void showCodeScannerPreview() {
        codeScanner.startPreview();
    }


    @Override
    public void onPause() {
        codeScanner.releaseResources();
        super.onPause();
    }
}
