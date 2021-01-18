package com.example.qrcodescannerevent;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.qrcodescannerevent.ui.game.QrCodeScannerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //disable all stat based tinting
        navView.setItemIconTintList(null);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }

    //use this method for QrCodeScannerFragment, since this method is deprecated in fragments
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //cant call this in fragment because its deprecated fragment.resultBoys();
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        QrCodeScannerFragment fragment = (QrCodeScannerFragment) navHostFragment.getChildFragmentManager().getFragments().get(0);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && fragment != null) {
            fragment.showCodeScannerPreview();
        } else {
            // do some deny stuff ask permission again
        }
    }

}
