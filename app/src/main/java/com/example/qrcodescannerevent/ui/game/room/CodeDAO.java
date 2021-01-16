package com.example.qrcodescannerevent.ui.game.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CodeDAO {

    @Insert
    void insert(QrCodeItem... items);

    @Update
    void update(QrCodeItem... items);

    @Delete
    void delete(QrCodeItem... items);

    @Query("DELETE FROM CodeTable")
    void deleteAll();

    @Query("SELECT * FROM CodeTable")
    List<QrCodeItem> getItems();

    @Query("SELECT * FROM CodeTable WHERE qr_code_number =:qr_code_number")
    QrCodeItem findItemByQrCodeNumber(String qr_code_number);

    @Query("SELECT * FROM CodeTable WHERE question =:question")
    QrCodeItem findItemByQuestion(String question);

    @Query("UPDATE CodeTable SET activated_status=:activatedStatus WHERE qr_code_number = :qr_code_number")
    void updateActivatedStatus(boolean activatedStatus, String qr_code_number);

    @Query("UPDATE CodeTable SET answered_status=:answerStatus WHERE qr_code_number = :qr_code_number")
    void updateAnswerStatus(boolean answerStatus, String qr_code_number);

    @Query("UPDATE CodeTable SET scanned_status=:isScanned WHERE qr_code_number = :qr_code_number")
    void updateScannedStatus(boolean isScanned, String qr_code_number);

}
