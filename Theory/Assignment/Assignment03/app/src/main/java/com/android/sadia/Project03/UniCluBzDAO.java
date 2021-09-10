package com.android.sadia.Project03;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UniCluBzDAO {

    @Insert
    void insert(UniCluBzList uniCluBzList);

    @Update
    void update(UniCluBzList uniCluBzList);

    @Query("SELECT * FROM university_affiliation_table ORDER BY student_id DESC")
    LiveData<List<UniCluBzList>> getAllUniCluBzLists();

}
