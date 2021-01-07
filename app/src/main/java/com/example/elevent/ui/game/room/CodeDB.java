package com.example.elevent.ui.game.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {QrCodeItem.class}, version = 9)
@TypeConverters({Converters.class})
public abstract class CodeDB extends RoomDatabase {

    private static CodeDB INSTANCE;

    public abstract CodeDAO getItemDAO();

    public static CodeDB getCodeDB(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(),
                            CodeDB.class, "codeDB").
                            allowMainThreadQueries().
                            fallbackToDestructiveMigration().
                            build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
