package com.example.elevent.ui.game;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.elevent.MainActivity;
import com.example.elevent.R;
import com.example.elevent.ui.game.room.CodeDAO;
import com.example.elevent.ui.game.room.QrCodeItem;
import com.example.elevent.ui.info.DetailedInfoFragmentArgs;
import com.example.elevent.utils.Utils;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameFragment extends Fragment {

    private final static String TAG = "GameFragment";

    List<QrCodeItem> dataSet = new ArrayList<>();
    CodeDAO dao;
    private MaterialCardView continueBtn;
    private TextView gameProgressText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_game, container, false);

        setupDataSet(root.getContext());
        dao = Utils.getCodeDAO(root.getContext());
        setupCodeDB();

        String qr_code_string = GameFragmentArgs.fromBundle(getArguments()).getQrCode();


        Button scanBtn = root.findViewById(R.id.scan_qr_code_btn);
        continueBtn = root.findViewById(R.id.game_continue_btn_wrapper);
        gameProgressText = root.findViewById(R.id.game_progress_text);

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

        qr_code_image_01.setBackgroundResource(R.drawable.qr_code_image_01);
        qr_code_image_02.setBackgroundResource(R.drawable.qr_code_image_02);
        qr_code_image_03.setBackgroundResource(R.drawable.qr_code_image_03);
        qr_code_image_04.setBackgroundResource(R.drawable.qr_code_image_04);
        qr_code_image_05.setBackgroundResource(R.drawable.qr_code_image_05);
        qr_code_image_06.setBackgroundResource(R.drawable.qr_code_image_06);
        qr_code_image_07.setBackgroundResource(R.drawable.qr_code_image_07);
        qr_code_image_08.setBackgroundResource(R.drawable.qr_code_image_08);
        qr_code_image_09.setBackgroundResource(R.drawable.qr_code_image_09);
        qr_code_image_10.setBackgroundResource(R.drawable.qr_code_image_10);

        List<ImageView> resultImageList = new ArrayList<ImageView>() {{
            add(result_image_01);
            add(result_image_02);
            add(result_image_03);
            add(result_image_04);
            add(result_image_05);
            add(result_image_06);
            add(result_image_07);
            add(result_image_08);
            add(result_image_09);
            add(result_image_10);
        }};


        showDialog(qr_code_string, root.getContext(), resultImageList);
        setupResultImage(resultImageList);

        gameProgressText.setText(getProgressionText(root.getContext()));
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.navigateToNewFragment(root.getContext(), R.id.navigation_qr_code_scanner);
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: open dialog for price ;)
            }
        });

        return root;
    }

    private void showDialog(String qr_code_string, Context context, List<ImageView> list) {
        if (!qr_code_string.equals("QR0")) {
            //if the qr code is already scanned show toast
            if (dao.findItemByQrCodeNumber(qr_code_string).isScanned()) {
                Utils.createToast(Utils.getStringFromResource(R.string.code_already_scanned_hint, context), context);
            } else {
                createQuestionDialog(context, qr_code_string, list);
            }

        }
    }

    private void setupDataSet(Context context) {
        QrCodeItem item_01 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_01, context),
                R.drawable.qr_code_image_01,
                Utils.getStringFromResource(R.string.game_question_01, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_01, context),
                Utils.getStringFromResource(R.string.right_answer_01, context),
                false, false, false);

        QrCodeItem item_02 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_02, context),
                R.drawable.qr_code_image_02,
                Utils.getStringFromResource(R.string.game_question_02, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_02, context),
                Utils.getStringFromResource(R.string.right_answer_02, context),
                false, false, false);

        QrCodeItem item_03 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_03, context),
                R.drawable.qr_code_image_03,
                Utils.getStringFromResource(R.string.game_question_03, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_03, context),
                Utils.getStringFromResource(R.string.right_answer_03, context),
                false, false, false);

        QrCodeItem item_04 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_04, context),
                R.drawable.qr_code_image_04,
                Utils.getStringFromResource(R.string.game_question_04, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_04, context),
                Utils.getStringFromResource(R.string.right_answer_04, context),
                false, false, false);

        QrCodeItem item_05 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_05, context),
                R.drawable.qr_code_image_05,
                Utils.getStringFromResource(R.string.game_question_05, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_05, context),
                Utils.getStringFromResource(R.string.right_answer_05, context),
                false, false, false);

        QrCodeItem item_06 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_06, context),
                R.drawable.qr_code_image_06,
                Utils.getStringFromResource(R.string.game_question_06, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_06, context),
                Utils.getStringFromResource(R.string.right_answer_06, context),
                false, false, false);

        QrCodeItem item_07 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_07, context),
                R.drawable.qr_code_image_07,
                Utils.getStringFromResource(R.string.game_question_07, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_07, context),
                Utils.getStringFromResource(R.string.right_answer_07, context),
                false, false, false);

        QrCodeItem item_08 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_08, context),
                R.drawable.qr_code_image_08,
                Utils.getStringFromResource(R.string.game_question_08, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_08, context),
                Utils.getStringFromResource(R.string.right_answer_08, context),
                false, false, false);

        QrCodeItem item_09 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_09, context),
                R.drawable.qr_code_image_09,
                Utils.getStringFromResource(R.string.game_question_09, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_09, context),
                Utils.getStringFromResource(R.string.right_answer_09, context),
                false, false, false);

        QrCodeItem item_10 = new QrCodeItem(Utils.getStringFromResource(R.string.qr_code_10, context),
                R.drawable.qr_code_image_10,
                Utils.getStringFromResource(R.string.game_question_10, context),
                Utils.getStringArrayAsListFromResource(R.array.wrong_answer_list_10, context),
                Utils.getStringFromResource(R.string.right_answer_10, context),
                false, false, false);


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
        int count = 0;
        for (QrCodeItem item : dao.getItems()) {
            if (item.isAnsweredRight()) {
                count++;
            }
        }
        return count;
    }

    private int getTotalNumberOfAnsweredQuestions() {
        int count = 0;
        for (QrCodeItem item : dao.getItems()) {
            if (item.isActivated()) {
                count++;
            }
        }
        return count;
    }

    private void createQuestionDialog(Context context, String qr_code, List<ImageView> list) {
        QrCodeItem item = dao.findItemByQrCodeNumber(qr_code);
        //add all answer options into a list
        ArrayList<String> answerList = (ArrayList<String>) item.getWrongAnswerList();
        String rightAnswer = item.getRightAnswer();
        answerList.add(rightAnswer);
        randomOrderGenerator(answerList);

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.question_dialog);

        ViewGroup answerOptionLayout01 = dialog.findViewById(R.id.answer_option_01);
        ViewGroup answerOptionLayout02 = dialog.findViewById(R.id.answer_option_02);
        ViewGroup answerOptionLayout03 = dialog.findViewById(R.id.answer_option_03);
        ViewGroup answerOptionLayout04 = dialog.findViewById(R.id.answer_option_04);

        TextView questionHeader = dialog.findViewById(R.id.question_header);
        TextView question = dialog.findViewById(R.id.dialog_question_text);
        Button submitBtn = dialog.findViewById(R.id.submit_answer_btn);
        Button closeBtn = dialog.findViewById(R.id.game_dialog_close_btn);

        CheckBox checkBox_answer_01 = answerOptionLayout01.findViewById(R.id.answer_option_check_box);
        CheckBox checkBox_answer_02 = answerOptionLayout02.findViewById(R.id.answer_option_check_box);
        CheckBox checkBox_answer_03 = answerOptionLayout03.findViewById(R.id.answer_option_check_box);
        CheckBox checkBox_answer_04 = answerOptionLayout04.findViewById(R.id.answer_option_check_box);

        TextView answer_option_01 = answerOptionLayout01.findViewById(R.id.answer_option_text);
        TextView answer_option_02 = answerOptionLayout02.findViewById(R.id.answer_option_text);
        TextView answer_option_03 = answerOptionLayout03.findViewById(R.id.answer_option_text);
        TextView answer_option_04 = answerOptionLayout04.findViewById(R.id.answer_option_text);

        answer_option_01.setText(answerList.get(0));
        answer_option_02.setText(answerList.get(1));
        answer_option_03.setText(answerList.get(2));
        answer_option_04.setText(answerList.get(3));

        // example --> QR10 --> 10. Frage
        String textHeader = qr_code.replace("QR", "") + ". " + Utils.getStringFromResource(R.string.question_header, context);
        question.setText(item.getQuestion());
        questionHeader.setText(textHeader);

        checkBox_answer_01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox_answer_02.setChecked(false);
                    checkBox_answer_03.setChecked(false);
                    checkBox_answer_04.setChecked(false);
                }
            }
        });

        checkBox_answer_02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox_answer_01.setChecked(false);
                    checkBox_answer_03.setChecked(false);
                    checkBox_answer_04.setChecked(false);
                }
            }
        });


        checkBox_answer_03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox_answer_01.setChecked(false);
                    checkBox_answer_02.setChecked(false);
                    checkBox_answer_04.setChecked(false);
                }
            }
        });

        checkBox_answer_04.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    checkBox_answer_01.setChecked(false);
                    checkBox_answer_02.setChecked(false);
                    checkBox_answer_03.setChecked(false);
                }
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox_answer_01.isChecked()) {
                    updateAnswerStatus(qr_code, answer_option_01, rightAnswer, list);
                } else if (checkBox_answer_02.isChecked()) {
                    updateAnswerStatus(qr_code, answer_option_02, rightAnswer, list);
                } else if (checkBox_answer_03.isChecked()) {
                    updateAnswerStatus(qr_code, answer_option_03, rightAnswer, list);
                } else if (checkBox_answer_04.isChecked()) {
                    updateAnswerStatus(qr_code, answer_option_04, rightAnswer, list);
                } else {
                    Utils.createToast(Utils.getStringFromResource(R.string.no_answer_selected_hint, context), context);
                }
                dao.updateScannedStatus(true, qr_code);
                if (getTotalNumberOfAnsweredQuestions() == 4) {
                    continueBtn.setVisibility(View.VISIBLE);
                }
                gameProgressText.setText(getProgressionText(context));
                dialog.cancel();
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    //shuffle list
    private ArrayList<String> randomOrderGenerator(ArrayList<String> list) {
        Collections.shuffle(list);
        return list;
    }

    private void changeResultImage(String qrCodeText, List<ImageView> list, boolean isAnsweredRight) {
        switch (qrCodeText) {
            case "QR1":
                setRightResultImage(list.get(0), isAnsweredRight);
                break;
            case "QR2":
                setRightResultImage(list.get(1), isAnsweredRight);
                break;
            case "QR3":
                setRightResultImage(list.get(2), isAnsweredRight);
                break;
            case "QR4":
                setRightResultImage(list.get(3), isAnsweredRight);
                break;
            case "QR5":
                setRightResultImage(list.get(4), isAnsweredRight);
                break;
            case "QR6":
                setRightResultImage(list.get(5), isAnsweredRight);
                break;
            case "QR7":
                setRightResultImage(list.get(6), isAnsweredRight);
                break;
            case "QR8":
                setRightResultImage(list.get(7), isAnsweredRight);
                break;
            case "QR9":
                setRightResultImage(list.get(8), isAnsweredRight);
                break;
            case "QR10":
                setRightResultImage(list.get(9), isAnsweredRight);
                break;
            default:
                break;
        }
    }

    private void setRightResultImage(ImageView view, boolean isAnsweredRight) {
        view.setVisibility(View.VISIBLE);
        if (isAnsweredRight) {
            view.setBackgroundResource(R.drawable.game_right_answer_v2);
        } else {
            view.setBackgroundResource(R.drawable.game_wrong_answer_v2);
        }

    }

    private void updateAnswerStatus(String qr_code, TextView view, String rightAnswer, List<ImageView> list) {
        dao.updateActivatedStatus(true, qr_code);
        if (view.getText().toString().equals(rightAnswer)) {
            changeResultImage(qr_code, list, true);
            dao.updateAnswerStatus(true, qr_code);
        } else {
            Log.d(TAG, "wrong result");
            changeResultImage(qr_code, list, false);
            dao.updateAnswerStatus(false, qr_code);

        }
    }

    private void setupResultImage(List<ImageView> viewList) {
        List<QrCodeItem> list = dao.getItems();
        int count = 0;
        for (QrCodeItem item : list) {
            if (item.isActivated()) {
                viewList.get(count).setVisibility(View.VISIBLE);
                if (item.isAnsweredRight()) {
                    viewList.get(count).setBackgroundResource(R.drawable.game_right_answer_v2);
                } else {
                    viewList.get(count).setBackgroundResource(R.drawable.game_wrong_answer_v2);
                }
            }
            count++;
        }

    }

}
