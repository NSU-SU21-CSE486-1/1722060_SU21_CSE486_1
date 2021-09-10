package com.android.sadia.Project03;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

@Database(entities = {UniCluBzList.class}, version = 1)
public abstract class UniCluBzListDatabase extends RoomDatabase {

    private static UniCluBzListDatabase instance;

    public abstract UniCluBzDAO uniCluBzDAO();

    public static synchronized UniCluBzListDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UniCluBzListDatabase.class, "university_affiliation_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UniCluBzDAO uniCluBzDAO;

        private PopulateDbAsyncTask(UniCluBzListDatabase db) {
            uniCluBzDAO = db.uniCluBzDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            uniCluBzDAO.insert(new UniCluBzList("North South University",
                    "Electrical and Computer Engineering", 1722060042,
                    "Undergraduate","sumiya.sadia@northsouth.edu"));
            uniCluBzDAO.insert(new UniCluBzList("North South University",
                    "Department of Law", 1722222042,
                    "Graduate","sumiya.sadia97@gmail.com"));

            return null;
        }
    }
}

