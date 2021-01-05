package com.example.elevent.ui.game;

import android.widget.ImageView;

public class QrCodeImageHolder {

    ImageView qr_code;
    ImageView result;

    public QrCodeImageHolder(ImageView qr_code, ImageView result) {
        this.qr_code = qr_code;
        this.result = result;
    }

    public ImageView getQr_code() {
        return qr_code;
    }

    public void setQr_code(ImageView qr_code) {
        this.qr_code = qr_code;
    }

    public ImageView getResult() {
        return result;
    }

    public void setResult(ImageView result) {
        this.result = result;
    }
}
