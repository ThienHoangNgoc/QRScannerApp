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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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
                R.drawable.info_btn,
                Utils.getStringFromResource(R.string.info_title, getActivity()),
                Utils.getStringFromResource(R.string.info_subtitle, getActivity()),
                R.id.navigation_info
        );

        setupStartButton(root,
                R.id.game_btn_layout,
                R.drawable.game_btn,
                Utils.getStringFromResource(R.string.game_title, getActivity()),
                Utils.getStringFromResource(R.string.game_subtitle, getActivity()),
                R.id.navigation_game
        );

        setupClickListener(root.findViewById(R.id.map_btn_layout), R.id.navigation_map);



        setupClickListener(root.findViewById(R.id.imprint_btn_layout), R.id.navigation_imprint);

        return root;
    }


    private void setupStartButton(View root, int linearLayoutID, int backgroundID, String title, String subtitle, int fragmentID) {
        ViewGroup layout = root.findViewById(linearLayoutID);
        layout.setBackground(ContextCompat.getDrawable(getActivity(), backgroundID));
        TextView titleView = layout.findViewById(R.id.title_text);
        TextView subtitleView = layout.findViewById(R.id.subtitle_text);
        titleView.setText(title);
        subtitleView.setText(subtitle);
        setupClickListener(layout, fragmentID);
    }

    private void setupClickListener(ViewGroup view, int fragmentID) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(requireActivity(), fragmentID);
            }
        });

    }
}