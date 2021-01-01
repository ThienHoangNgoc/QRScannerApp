package com.example.elevent.ui.imprint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elevent.R;

public class ImprintFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_imprint, container, false);
        TextView readMoreBtn = root.findViewById(R.id.read_more_btn);
        TextView imprintText03 = root.findViewById(R.id.imprint_text_03);
        readMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imprintText03.setVisibility(View.VISIBLE);
                readMoreBtn.setVisibility(View.GONE);
            }
        });

        return root;
    }

}
