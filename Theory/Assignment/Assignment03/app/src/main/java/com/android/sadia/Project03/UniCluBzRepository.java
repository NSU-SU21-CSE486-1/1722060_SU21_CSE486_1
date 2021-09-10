package com.android.sadia.Project03;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import java.util.List;

public class UniCluBzRepository {

    private UniCluBzDAO uniCluBzDAO;
    private LiveData<List<UniCluBzList>> allUniCluBzLists;

    public UniCluBzRepository(Application application){
        UniCluBzListDatabase database = UniCluBzListDatabase.getInstance(application);
        uniCluBzDAO = database.uniCluBzDAO();
        allUniCluBzLists = uniCluBzDAO.getAllUniCluBzLists();
    }

    public void insert(UniCluBzList uniCluBzList){
        new InsertUniCluBzListAsyncTask(uniCluBzDAO).execute(uniCluBzList);
    }

    public void update(UniCluBzList uniCluBzList){
        new UpdateUniCluBzListAsyncTask(uniCluBzDAO).execute(uniCluBzList);
    }

    public LiveData<List<UniCluBzList>> getAllUniCluBzLists() {
        return allUniCluBzLists;
    }

    private static class InsertUniCluBzListAsyncTask extends AsyncTask<UniCluBzList, Void, Void>{
        private UniCluBzDAO uniCluBzDAO;
        private InsertUniCluBzListAsyncTask(UniCluBzDAO uniCluBzDAO){
            this.uniCluBzDAO = uniCluBzDAO;
        }

        @Override
        protected Void doInBackground(UniCluBzList... uniCluBzLists) {
            uniCluBzDAO.insert(uniCluBzLists[0]);
            return null;
        }
    }
    private static class UpdateUniCluBzListAsyncTask extends AsyncTask<UniCluBzList, Void, Void>{
        private UniCluBzDAO uniCluBzDAO;
        private UpdateUniCluBzListAsyncTask(UniCluBzDAO uniCluBzDAO){
            this.uniCluBzDAO = uniCluBzDAO;
        }

        @Override
        protected Void doInBackground(UniCluBzList... uniCluBzLists) {
            uniCluBzDAO.update(uniCluBzLists[0]);
            return null;
        }
    }
}
