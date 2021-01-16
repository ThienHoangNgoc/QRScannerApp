package com.example.qrcodescannerevent.ui.info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qrcodescannerevent.R;
import com.example.qrcodescannerevent.utils.Utils;

public class MakingOffFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_making_off, container, false);

        Button playBtn = root.findViewById(R.id.play_making_off_btn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when the play button is clicked, open the youtube link
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Utils.getStringFromResource(R.string.making_off_link, root.getContext())));
                startActivity(intent);

            }
        });

        return root;
    }
}
