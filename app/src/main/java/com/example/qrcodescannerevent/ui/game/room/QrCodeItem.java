package com.example.qrcodescannerevent.ui.game.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "CodeTable")
public class QrCodeItem {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "qr_code_number")
    private String qr_code_number;

    @ColumnInfo(name = "image_id")
    int imageID;

    @ColumnInfo(name = "question")
    String question;

    @ColumnInfo(name = "wrong_answer_list")
    ArrayList<String> wrongAnswerList;

    @ColumnInfo(name = "right_answer")
    String rightAnswer;

    //when answer is answered right --> true else false
    @ColumnInfo(name = "answered_status")
    boolean isAnsweredRight;

    @ColumnInfo(name = "activated_status")
    boolean isActivated;

    @ColumnInfo(name = "scanned_status")

    boolean isScanned;

    public QrCodeItem(String qr_code_number, int imageID, String question, ArrayList<String> wrongAnswerList, String rightAnswer, boolean isAnsweredRight, boolean isActivated, boolean isScanned) {
        this.qr_code_number = qr_code_number;
        this.imageID = imageID;
        this.question = question;
        this.wrongAnswerList = wrongAnswerList;
        this.rightAnswer = rightAnswer;
        this.isAnsweredRight = isAnsweredRight;
        this.isActivated = isActivated;
        this.isScanned = isScanned;
    }

    @NonNull
    public String getQr_code_number() {
        return qr_code_number;
    }

    public void setQr_code_number(@NonNull String qr_code_number) {
        this.qr_code_number = qr_code_number;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getWrongAnswerList() {
        return wrongAnswerList;
    }

    public void setWrongAnswerList(ArrayList<String> wrongAnswerList) {
        this.wrongAnswerList = wrongAnswerList;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public boolean isAnsweredRight() {
        return isAnsweredRight;
    }

    public void setAnsweredRight(boolean answeredRight) {
        isAnsweredRight = answeredRight;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isScanned() {
        return isScanned;
    }

    public void setScanned(boolean scanned) {
        isScanned = scanned;
    }
}
