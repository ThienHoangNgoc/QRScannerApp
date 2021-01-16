package com.example.qrcodescannerevent.ui.info.model;

public class InfoItem {


    String title;
    String subTitle;
    int imageID;

    public InfoItem(String title, String subTitle, int imageID) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
