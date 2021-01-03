package com.example.elevent.ui.info.model;

public class QuestionAnswerItem {

    String question_01;
    String question_02;
    String question_03;
    String question_04;
    String answer_01;
    String answer_02;
    String answer_03;
    String answer_04;
    String title;
    String subtitle;
    int imageID;

    public QuestionAnswerItem(String question_01, String question_02, String question_03, String question_04, String answer_01, String answer_02, String answer_03, String answer_04, String title, String subtitle, int imageID) {
        this.question_01 = question_01;
        this.question_02 = question_02;
        this.question_03 = question_03;
        this.question_04 = question_04;
        this.answer_01 = answer_01;
        this.answer_02 = answer_02;
        this.answer_03 = answer_03;
        this.answer_04 = answer_04;
        this.title = title;
        this.subtitle = subtitle;
        this.imageID = imageID;
    }


    public String getQuestion_01() {
        return question_01;
    }

    public void setQuestion_01(String question_01) {
        this.question_01 = question_01;
    }

    public String getQuestion_02() {
        return question_02;
    }

    public void setQuestion_02(String question_02) {
        this.question_02 = question_02;
    }

    public String getQuestion_03() {
        return question_03;
    }

    public void setQuestion_03(String question_03) {
        this.question_03 = question_03;
    }

    public String getQuestion_04() {
        return question_04;
    }

    public void setQuestion_04(String question_04) {
        this.question_04 = question_04;
    }

    public String getAnswer_01() {
        return answer_01;
    }

    public void setAnswer_01(String answer_01) {
        this.answer_01 = answer_01;
    }

    public String getAnswer_02() {
        return answer_02;
    }

    public void setAnswer_02(String answer_02) {
        this.answer_02 = answer_02;
    }

    public String getAnswer_03() {
        return answer_03;
    }

    public void setAnswer_03(String answer_03) {
        this.answer_03 = answer_03;
    }

    public String getAnswer_04() {
        return answer_04;
    }

    public void setAnswer_04(String answer_04) {
        this.answer_04 = answer_04;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
