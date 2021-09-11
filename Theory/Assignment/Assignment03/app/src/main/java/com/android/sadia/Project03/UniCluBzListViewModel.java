package com.android.sadia.Project03;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UniCluBzListViewModel extends AndroidViewModel {
    private UniCluBzRepository repository;
    private LiveData<List<UniCluBzList>> allUniCluBzLists;
    public UniCluBzListViewModel(@NonNull @NotNull Application application) {
        super(application);

        repository = new UniCluBzRepository(application);
        allUniCluBzLists = repository.getAllUniCluBzLists();
    }

    public void insert(UniCluBzList uniCluBzList){
        repository.insert(uniCluBzList);
    }

    public void update(UniCluBzList uniCluBzList){
        repository.update(uniCluBzList);

    }

    public LiveData<List<UniCluBzList>> getAllUniCluBzLists() {
        return allUniCluBzLists;
    }
}
