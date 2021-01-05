package com.example.elevent.ui.game;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elevent.R;
import com.example.elevent.ui.game.room.CodeDAO;
import com.example.elevent.ui.game.room.QrCodeItem;
import com.example.elevent.ui.info.DetailedInfoFragmentArgs;
import com.example.elevent.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameFragment extends Fragment {

    List<QrCodeItem> dataSet = new ArrayList<>();
    CodeDAO dao;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Todo: use RoomDB, create RNG order for questions, alertdialog

        View root = inflater.inflate(R.layout.fragment_game, container, false);
        String qr_code_string = GameFragmentArgs.fromBundle(getArguments()).getQrCode();
        dao = Utils.getCodeDAO(root.getContext());

        Button scanBtn = root.findViewById(R.id.scan_qr_code_btn);
        TextView textView = root.findViewById(R.id.game_progress_text);
        ViewGroup qr_code_item_layout_01 = root.findViewById(R.id.qr_code_item_01);
        ViewGroup qr_code_item_layout_02 = root.findViewById(R.id.qr_code_item_02);
        ViewGroup qr_code_item_layout_03 = root.findViewById(R.id.qr_code_item_03);
        ViewGroup qr_code_item_layout_04 = root.findViewById(R.id.qr_code_item_04);
        ViewGroup qr_code_item_layout_05 = root.findViewById(R.id.qr_code_item_05);
        ViewGroup qr_code_item_layout_06 = root.findViewById(R.id.qr_code_item_06);
        ViewGroup qr_code_item_layout_07 = root.findViewById(R.id.qr_code_item_07);
        ViewGroup qr_code_item_layout_08 = root.findViewById(R.id.qr_code_item_08);
        ViewGroup qr_code_item_layout_09 = root.findViewById(R.id.qr_code_item_09);
        ViewGroup qr_code_item_layout_10 = root.findViewById(R.id.qr_code_item_10);

        ImageView qr_code_image_01 = qr_code_item_layout_01.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_02 = qr_code_item_layout_02.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_03 = qr_code_item_layout_03.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_04 = qr_code_item_layout_04.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_05 = qr_code_item_layout_05.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_06 = qr_code_item_layout_06.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_07 = qr_code_item_layout_07.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_08 = qr_code_item_layout_08.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_09 = qr_code_item_layout_09.findViewById(R.id.qr_code_image);
        ImageView qr_code_image_10 = qr_code_item_layout_10.findViewById(R.id.qr_code_image);

        ImageView result_image_01 = qr_code_item_layout_01.findViewById(R.id.result_icon_image);
        ImageView result_image_02 = qr_code_item_layout_02.findViewById(R.id.result_icon_image);
        ImageView result_image_03 = qr_code_item_layout_03.findViewById(R.id.result_icon_image);
        ImageView result_image_04 = qr_code_item_layout_04.findViewById(R.id.result_icon_image);
        ImageView result_image_05 = qr_code_item_layout_05.findViewById(R.id.result_icon_image);
        ImageView result_image_06 = qr_code_item_layout_06.findViewById(R.id.result_icon_image);
        ImageView result_image_07 = qr_code_item_layout_07.findViewById(R.id.result_icon_image);
        ImageView result_image_08 = qr_code_item_layout_08.findViewById(R.id.result_icon_image);
        ImageView result_image_09 = qr_code_item_layout_09.findViewById(R.id.result_icon_image);
        ImageView result_image_10 = qr_code_item_layout_10.findViewById(R.id.result_icon_image);

        List<QrCodeImageHolder> imageHolderList = new ArrayList<QrCodeImageHolder>() {
            {
                add(new QrCodeImageHolder(qr_code_image_01, result_image_01));
                add(new QrCodeImageHolder(qr_code_image_02, result_image_02));
                add(new QrCodeImageHolder(qr_code_image_03, result_image_03));
                add(new QrCodeImageHolder(qr_code_image_04, result_image_04));
                add(new QrCodeImageHolder(qr_code_image_05, result_image_05));
                add(new QrCodeImageHolder(qr_code_image_06, result_image_06));
                add(new QrCodeImageHolder(qr_code_image_07, result_image_07));
                add(new QrCodeImageHolder(qr_code_image_08, result_image_08));
                add(new QrCodeImageHolder(qr_code_image_09, result_image_09));
                add(new QrCodeImageHolder(qr_code_image_10, result_image_10));
            }
        };


        showDialog(qr_code_string, root.getContext());
        setupDataSet(root.getContext());
        setupCodeDB();

        List<QrCodeItem> dbList = dao.getItems();
        int count = 0;
        for (QrCodeItem item : dbList) {
            setupViews(imageHolderList.get(count).getQr_code(), imageHolderList.get(count).getResult(), item);
            count++;
        }


        textView.setText(getProgressionText(root.getContext()));
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(root.getContext(), R.id.navigation_qr_code_scanner);
            }
        });

        return root;
    }

    private void showDialog(String qr_code_string, Context context) {
        if (!qr_code_string.equals("QR0")) {
            switch (qr_code_string) {
                case "QR1":
                    Utils.createToast("QR1", context);
                    break;
                case "QR2":
                    Utils.createToast("QR2", context);
                    break;
                case "QR3":
                    Utils.createToast("QR3", context);
                    break;
                case "QR4":
                    Utils.createToast("QR4", context);
                    break;
                case "QR5":
                    Utils.createToast("QR5", context);
                    break;
                case "QR6":
                    Utils.createToast("QR6", context);
                    break;
                case "QR7":
                    Utils.createToast("QR7", context);
                    break;
                case "QR8":
                    Utils.createToast("QR8", context);
                    break;
                case "QR9":
                    Utils.createToast("QR9", context);
                    break;
                case "QR10":
                    Utils.createToast("QR10", context);
                    break;
                default:
                    break;
            }
        }
    }

    private void setupDataSet(Context context) {
        QrCodeItem item_01 = new QrCodeItem(R.drawable.qr_code_image_01,
                Utils.getStringFromResource(R.string.game_question_01, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_01, context),
                Utils.getStringFromResource(R.string.right_answer_01, context),
                false, false);

        QrCodeItem item_02 = new QrCodeItem(R.drawable.qr_code_image_02,
                Utils.getStringFromResource(R.string.game_question_02, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_02, context),
                Utils.getStringFromResource(R.string.right_answer_02, context),
                false, false);

        QrCodeItem item_03 = new QrCodeItem(R.drawable.qr_code_image_03,
                Utils.getStringFromResource(R.string.game_question_03, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_03, context),
                Utils.getStringFromResource(R.string.right_answer_03, context),
                false, false);

        QrCodeItem item_04 = new QrCodeItem(R.drawable.qr_code_image_04,
                Utils.getStringFromResource(R.string.game_question_04, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_04, context),
                Utils.getStringFromResource(R.string.right_answer_04, context),
                false, false);

        QrCodeItem item_05 = new QrCodeItem(R.drawable.qr_code_image_05,
                Utils.getStringFromResource(R.string.game_question_05, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_05, context),
                Utils.getStringFromResource(R.string.right_answer_05, context),
                false, false);

        QrCodeItem item_06 = new QrCodeItem(R.drawable.qr_code_image_06,
                Utils.getStringFromResource(R.string.game_question_06, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_06, context),
                Utils.getStringFromResource(R.string.right_answer_06, context),
                false, false);

        QrCodeItem item_07 = new QrCodeItem(R.drawable.qr_code_image_07,
                Utils.getStringFromResource(R.string.game_question_07, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_07, context),
                Utils.getStringFromResource(R.string.right_answer_07, context),
                false, false);

        QrCodeItem item_08 = new QrCodeItem(R.drawable.qr_code_image_08,
                Utils.getStringFromResource(R.string.game_question_08, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_08, context),
                Utils.getStringFromResource(R.string.right_answer_08, context),
                false, false);

        QrCodeItem item_09 = new QrCodeItem(R.drawable.qr_code_image_09,
                Utils.getStringFromResource(R.string.game_question_09, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_09, context),
                Utils.getStringFromResource(R.string.right_answer_09, context),
                false, false);

        QrCodeItem item_10 = new QrCodeItem(R.drawable.qr_code_image_10,
                Utils.getStringFromResource(R.string.game_question_10, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_10, context),
                Utils.getStringFromResource(R.string.right_answer_10, context),
                false, false);


        dataSet.addAll(Arrays.asList(item_01,
                item_02,
                item_03,
                item_04,
                item_05,
                item_06,
                item_07,
                item_08,
                item_09,
                item_10));
    }


    private void setupViews(ImageView qrCode, ImageView result, QrCodeItem item) {
        qrCode.setBackgroundResource(item.getImageID());
        if (item.isActivated()) {
            if (item.isAnsweredRight()) {
                result.setBackgroundResource(R.drawable.game_right_answer_v2);
            } else {
                result.setBackgroundResource(R.drawable.game_wrong_answer_v2);
            }
        }
    }

    //when there are no itmes in the db --> setup data
    private void setupCodeDB() {
        if (dao.getItems().size() == 0) {
            for (QrCodeItem item : dataSet) {
                dao.insert(item);
            }
        }
    }


    private CharSequence getProgressionText(Context context) {
        String progressionText = Utils.getStringFromResource(R.string.game_progress_text_01, context) +
                " <b>" +
                Utils.getStringFromResource(R.string.game_progress_text_02, context).replace("X", "" + getNumberOfRightAnswers()) + "</b> " +
                Utils.getStringFromResource(R.string.game_progress_text_03, context);

        return Html.fromHtml(progressionText);
    }

    private int getNumberOfRightAnswers() {
        //Todo: implement this
        return 0;
    }


}
