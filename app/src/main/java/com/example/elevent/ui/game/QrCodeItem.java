package com.example.elevent.ui.game;

import java.util.List;

public class QrCodeItem {
    int imageID;
    String question;
    List<String> wrongAnswerList;
    String rightAnswer;
    boolean isAnsweredRight;
    boolean isActivated;

    public QrCodeItem(int imageID, String question, List<String> wrongAnswerList, String rightAnswer, boolean isAnsweredRight, boolean isActivated) {
        this.imageID = imageID;
        this.question = question;
        this.wrongAnswerList = wrongAnswerList;
        this.rightAnswer = rightAnswer;
        this.isAnsweredRight = isAnsweredRight;
        this.isActivated = isActivated;
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

    public void setWrongAnswerList(List<String> wrongAnswerList) {
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
}
