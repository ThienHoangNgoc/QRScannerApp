package com.example.elevent.ui.info.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elevent.R;
import com.example.elevent.ui.info.model.InfoItem;
import com.example.elevent.utils.Utils;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private List<InfoItem> dataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewGroup layout;
        private final TextView title;
        private final TextView subtitle;
        private final ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.info_item_layout_id);
            title = itemView.findViewById(R.id.info_item_title);
            subtitle = itemView.findViewById(R.id.info_item_subtitle);
            imageView = itemView.findViewById(R.id.info_item_image);


            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ADAPTER", title.getText().toString());
                    Context context = v.getContext();

                    int infoItemNumber = 0;
                    if (getTitle().getText().toString().equals(Utils.getStringFromResource(R.string.info_item_title_01, context))) {
                        infoItemNumber = 1;

                    }
                    if (getTitle().getText().toString().equals(Utils.getStringFromResource(R.string.info_item_title_02, context))) {
                        infoItemNumber = 2;

                    }
                    if (getTitle().getText().toString().equals(Utils.getStringFromResource(R.string.info_item_title_03, context))) {
                        infoItemNumber = 3;

                    }
                    if (getTitle().getText().toString().equals(Utils.getStringFromResource(R.string.info_item_title_04, context))) {
                        infoItemNumber = 4;

                    }

                    Utils.passDataToNewFragment(v, infoItemNumber);

                }
            });

        }


        public TextView getTitle() {
            return title;
        }

        public TextView getSubtitle() {
            return subtitle;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    public InfoAdapter(List<InfoItem> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTitle().setText(dataSet.get(position).getTitle());
        holder.getSubtitle().setText(dataSet.get(position).getSubTitle());
        holder.getImageView().setBackgroundResource(dataSet.get(position).getImageID());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
