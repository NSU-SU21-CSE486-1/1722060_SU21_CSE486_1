package com.android.sadia.Project03;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {UniCluBzList.class}, version = 1)
public abstract class UniCluBzListDatabase extends RoomDatabase {

    private static UniCluBzListDatabase instance;

    public abstract UniCluBzDAO uniCluBzDAO();

    public static synchronized UniCluBzListDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UniCluBzListDatabase.class, "university_affiliation_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

