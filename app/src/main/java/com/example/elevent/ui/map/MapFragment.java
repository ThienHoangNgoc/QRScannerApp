package com.example.elevent.ui.map;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elevent.R;
import com.example.elevent.utils.Utils;

public class MapFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_map, container, false);
        Button locationBtn01 = root.findViewById(R.id.map_location_01);
        Button locationBtn02 = root.findViewById(R.id.map_location_02);
        ViewGroup locationBoxLayout01 = root.findViewById(R.id.map_info_box_layout_01);
        ViewGroup locationBoxLayout02 = root.findViewById(R.id.map_info_box_layout_02);
        TextView locationTitle01 = locationBoxLayout01.findViewById(R.id.location_title);
        TextView locationInfo01 = locationBoxLayout01.findViewById(R.id.location_info);
        TextView goToInfoBtn01 = locationBoxLayout01.findViewById(R.id.go_to_info_btn);

        TextView locationTitle02 = locationBoxLayout02.findViewById(R.id.location_title);
        TextView locationInfo02 = locationBoxLayout02.findViewById(R.id.location_info);
        TextView goToInfoBtn02 = locationBoxLayout02.findViewById(R.id.go_to_info_btn);

        //set data to views
        locationTitle01.setText(Utils.getStringFromResource(R.string.map_item_title_01,root.getContext()));
        locationInfo01.setText(Utils.getStringFromResource(R.string.map_item_text_01,root.getContext()));
        goToInfoBtn01.setText(Utils.getStringFromResource(R.string.map_go_to_info_btn,root.getContext()));

        locationTitle02.setText(Utils.getStringFromResource(R.string.map_item_title_02,root.getContext()));
        locationInfo02.setText(Utils.getStringFromResource(R.string.map_item_text_02,root.getContext()));
        goToInfoBtn02.setText(Utils.getStringFromResource(R.string.map_go_to_info_btn,root.getContext()));


        //click listeners
        locationBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibility(locationBoxLayout01);
            }
        });

        locationBtn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibility(locationBoxLayout02);
            }
        });

        goToInfoBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(root.getContext(),R.id.navigation_info);
            }
        });

        goToInfoBtn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(root.getContext(),R.id.navigation_info);
            }
        });


        return root;

    }

    private void setVisibility(ViewGroup viewGroup){
        if(viewGroup.getVisibility() == View.GONE){
            viewGroup.setVisibility(View.VISIBLE);
        }else {
            viewGroup.setVisibility(View.GONE);
        }
    }


}