package com.example.elevent.ui.info;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elevent.R;
import com.example.elevent.ui.info.model.QuestionAnswerItem;
import com.example.elevent.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DetailedInfoFragment extends Fragment {

    List<QuestionAnswerItem> dataSet = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detailed_info, container, false);
        ViewGroup layout = root.findViewById(R.id.info_header_box_in_details);
        TextView makingOffBtn = layout.findViewById(R.id.making_off_btn);
        ViewGroup qALayout_01 = root.findViewById(R.id.q_and_a_01);
        ViewGroup qALayout_02 = root.findViewById(R.id.q_and_a_02);
        ViewGroup qALayout_03 = root.findViewById(R.id.q_and_a_03);
        ViewGroup qALayout_04 = root.findViewById(R.id.q_and_a_04);
        TextView question_01 = qALayout_01.findViewById(R.id.info_question_text);
        TextView answer_01 = qALayout_01.findViewById(R.id.info_answer_text);
        TextView question_02 = qALayout_02.findViewById(R.id.info_question_text);
        TextView answer_02 = qALayout_02.findViewById(R.id.info_answer_text);
        TextView question_03 = qALayout_03.findViewById(R.id.info_question_text);
        TextView answer_03 = qALayout_03.findViewById(R.id.info_answer_text);
        TextView question_04 = qALayout_04.findViewById(R.id.info_question_text);
        TextView answer_04 = qALayout_04.findViewById(R.id.info_answer_text);

        ImageView itemImage = root.findViewById(R.id.info_item_image);
        TextView title = root.findViewById(R.id.info_item_title);
        TextView subtitle = root.findViewById(R.id.info_item_subtitle);


        int infoNumber = DetailedInfoFragmentArgs.fromBundle(getArguments()).getInfoItemNumber();

        fillDataSet(root.getContext());
        setupText(root.getContext(), infoNumber,
                question_01, answer_01,
                question_02, answer_02,
                question_03, answer_03,
                question_04, answer_04,
                title, subtitle,
                itemImage);

        makingOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //navigate to the making off fragment
                Utils.navigateToNewFragment(root.getContext(), R.id.navigation_making_off);
            }
        });


        return root;
    }

    /**
     *  set up data for the detailed fragment view
     * @param context
     * @param infoNumber
     * @param q1
     * @param a1
     * @param q2
     * @param a2
     * @param q3
     * @param a3
     * @param q4
     * @param a4
     * @param title
     * @param subtitle
     * @param image
     */
    private void setupText(Context context, int infoNumber, TextView q1, TextView a1,
                           TextView q2, TextView a2,
                           TextView q3, TextView a3,
                           TextView q4, TextView a4,
                           TextView title, TextView subtitle,
                           ImageView image) {
        if (infoNumber != 0) {
            QuestionAnswerItem item = dataSet.get(infoNumber - 1);
            q1.setText(item.getQuestion_01());
            q2.setText(item.getQuestion_02());
            q3.setText(item.getQuestion_03());
            q4.setText(item.getQuestion_04());
            a1.setText(item.getAnswer_01());
            a2.setText(item.getAnswer_02());
            a3.setText(item.getAnswer_03());
            a4.setText(item.getAnswer_04());
            title.setText(item.getTitle());
            subtitle.setText(item.getSubtitle());
            image.setBackgroundResource(item.getImageID());
        } else {
            q1.setText(Utils.getStringFromResource(R.string.detailed_info_error_text, context));
        }


    }

    private void fillDataSet(Context context) {
        QuestionAnswerItem item_01 = new QuestionAnswerItem(Utils.getStringFromResource(R.string.info_item_01_question_01, context),
                Utils.getStringFromResource(R.string.info_item_01_question_02, context),
                Utils.getStringFromResource(R.string.info_item_01_question_03, context),
                Utils.getStringFromResource(R.string.info_item_01_question_04, context),
                Utils.getStringFromResource(R.string.info_item_01_answer_01, context),
                Utils.getStringFromResource(R.string.info_item_01_answer_02, context),
                Utils.getStringFromResource(R.string.info_item_01_answer_03, context),
                Utils.getStringFromResource(R.string.info_item_01_answer_04, context),
                Utils.getStringFromResource(R.string.info_item_title_01, context),
                Utils.getStringFromResource(R.string.info_item_subtitle_01, context),
                R.drawable.info_item_image_01);

        QuestionAnswerItem item_02 = new QuestionAnswerItem(Utils.getStringFromResource(R.string.info_item_02_question_01, context),
                Utils.getStringFromResource(R.string.info_item_02_question_02, context),
                Utils.getStringFromResource(R.string.info_item_02_question_03, context),
                Utils.getStringFromResource(R.string.info_item_02_question_04, context),
                Utils.getStringFromResource(R.string.info_item_02_answer_01, context),
                Utils.getStringFromResource(R.string.info_item_02_answer_02, context),
                Utils.getStringFromResource(R.string.info_item_02_answer_03, context),
                Utils.getStringFromResource(R.string.info_item_02_answer_04, context),
                Utils.getStringFromResource(R.string.info_item_title_02, context),
                Utils.getStringFromResource(R.string.info_item_subtitle_02, context),
                R.drawable.info_item_image_02);

        QuestionAnswerItem item_03 = new QuestionAnswerItem(Utils.getStringFromResource(R.string.info_item_03_question_01, context),
                Utils.getStringFromResource(R.string.info_item_03_question_02, context),
                Utils.getStringFromResource(R.string.info_item_03_question_03, context),
                Utils.getStringFromResource(R.string.info_item_03_question_04, context),
                Utils.getStringFromResource(R.string.info_item_03_answer_01, context),
                Utils.getStringFromResource(R.string.info_item_03_answer_02, context),
                Utils.getStringFromResource(R.string.info_item_03_answer_03, context),
                Utils.getStringFromResource(R.string.info_item_03_answer_04, context),
                Utils.getStringFromResource(R.string.info_item_title_03, context),
                Utils.getStringFromResource(R.string.info_item_subtitle_03, context),
                R.drawable.info_item_image_03);

        QuestionAnswerItem item_04 = new QuestionAnswerItem(Utils.getStringFromResource(R.string.info_item_04_question_01, context),
                Utils.getStringFromResource(R.string.info_item_04_question_02, context),
                Utils.getStringFromResource(R.string.info_item_04_question_03, context),
                Utils.getStringFromResource(R.string.info_item_04_question_04, context),
                Utils.getStringFromResource(R.string.info_item_04_answer_01, context),
                Utils.getStringFromResource(R.string.info_item_04_answer_02, context),
                Utils.getStringFromResource(R.string.info_item_04_answer_03, context),
                Utils.getStringFromResource(R.string.info_item_04_answer_04, context),
                Utils.getStringFromResource(R.string.info_item_title_04, context),
                Utils.getStringFromResource(R.string.info_item_subtitle_04, context),
                R.drawable.info_item_image_04);

        dataSet.add(item_01);
        dataSet.add(item_02);
        dataSet.add(item_03);
        dataSet.add(item_04);
    }


}
