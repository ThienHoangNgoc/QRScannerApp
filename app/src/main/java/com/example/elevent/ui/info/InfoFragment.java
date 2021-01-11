package com.example.elevent.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elevent.R;
import com.example.elevent.ui.info.adapter.InfoAdapter;
import com.example.elevent.ui.info.model.InfoItem;
import com.example.elevent.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {

    List<InfoItem> dataSet = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.info_list);
        ViewGroup viewGroup = root.findViewById(R.id.info_header_layout);
        TextView makingOffBtn = viewGroup.findViewById(R.id.making_off_btn);

        //set up recycler view
        setupInfoData();
        InfoAdapter adapter = new InfoAdapter(dataSet);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        makingOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to the making off fragment
                Utils.navigateToNewFragment(root.getContext(),R.id.navigation_making_off);


            }
        });

        return root;
    }

    /**
     * setup the local data set
     */
    private void setupInfoData() {
        InfoItem infoItem_01 = new InfoItem(Utils.getStringFromResource(R.string.info_item_title_01, getContext()),
                Utils.getStringFromResource(R.string.info_item_subtitle_01, getContext()),
                R.drawable.info_item_image_01);
        InfoItem infoItem_02 = new InfoItem(Utils.getStringFromResource(R.string.info_item_title_02, getContext()),
                Utils.getStringFromResource(R.string.info_item_subtitle_02, getContext()),
                R.drawable.info_item_image_02);
        InfoItem infoItem_03 = new InfoItem(Utils.getStringFromResource(R.string.info_item_title_03, getContext()),
                Utils.getStringFromResource(R.string.info_item_subtitle_03, getContext()),
                R.drawable.info_item_image_03);
        InfoItem infoItem_04 = new InfoItem(Utils.getStringFromResource(R.string.info_item_title_04, getContext()),
                Utils.getStringFromResource(R.string.info_item_subtitle_04, getContext()),
                R.drawable.info_item_image_04);

        //prevent adding the dataSet every time this fragment is created --> list with duplicate entries (not wanted ones)
        if (dataSet.size() == 0) {
            dataSet.add(infoItem_01);
            dataSet.add(infoItem_02);
            dataSet.add(infoItem_03);
            dataSet.add(infoItem_04);
        }


    }
}