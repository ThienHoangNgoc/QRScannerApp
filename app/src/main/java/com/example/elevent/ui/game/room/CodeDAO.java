package com.example.elevent.ui.game.room;

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

    @Query("SELECT * FROM CodeTable WHERE code_id =:codeID")
    QrCodeItem findItemByID(long codeID);

    @Query("SELECT * FROM CodeTable WHERE question =:question")
    QrCodeItem findItemByQuestion(String question);

    @Query("UPDATE CodeTable SET activated_status=:activatedStatus WHERE code_id = :id")
    void updateActivatedStatus(boolean activatedStatus, long id);

    @Query("UPDATE CodeTable SET answered_status=:answerStatus WHERE code_id = :id")
    void updateAnswerStatus(boolean answerStatus, long id);

}
