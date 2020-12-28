package com.example.elevent.ui.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.elevent.R;
import com.example.elevent.ui.game.GameFragment;
import com.example.elevent.ui.imprint.ImprintFragment;
import com.example.elevent.ui.info.InfoFragment;
import com.example.elevent.ui.map.MapFragment;
import com.example.elevent.utils.Utils;

public class StartFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_start, container, false);


        setupStartButton(root,
                R.id.info_btn_layout,
                getActivity(),
                R.drawable.info_btn,
                Utils.getStringFromResource(R.string.info_title,getActivity()),
                Utils.getStringFromResource(R.string.info_subtitle,getActivity()),
                new InfoFragment()
        );

        setupStartButton(root,
                R.id.game_btn_layout,
                getActivity(),
                R.drawable.game_btn,
                Utils.getStringFromResource(R.string.game_title,getActivity()),
                Utils.getStringFromResource(R.string.game_subtitle,getActivity()),
                new GameFragment()
                );

        return root;
    }


    private void setupStartButton(View root, int linearLayoutID, FragmentActivity fragmentActivity, int backgroundID, String title, String subtitle, Fragment newFragment) {
        LinearLayout layout = root.findViewById(linearLayoutID);
        layout.setBackground(ContextCompat.getDrawable(fragmentActivity, backgroundID));
        TextView titleView = layout.findViewById(R.id.title_text);
        TextView subtitleView = layout.findViewById(R.id.subtitle_text);
        titleView.setText(title);
        subtitleView.setText(subtitle);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), newFragment);
                fragmentTransaction.commit();
            }
        });
    }
}