package com.sro.androidapp.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sro.androidapp.Dao.ItemDao;
import com.sro.androidapp.model.DataModel;

@Database(entities = {DataModel.class}, version = 1, exportSchema = false)
public abstract class ItemDatabase extends RoomDatabase {

    public abstract ItemDao mainDao();

    private static ItemDatabase database;

    final private static String DATABASE_NAME = "database";

    public synchronized static ItemDatabase getInstance(Context context) {
        if (database == null) {
            //When database is null
            database = Room.databaseBuilder(context.getApplicationContext(),
                    ItemDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }


}
