package com.sro.androidapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sro.androidapp.model.DataModel;

import java.util.List;

@Dao
public interface ItemDao {
    // declaring methods for database operation


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<DataModel> dataModelList);

    @Query("SELECT * FROM DataTable")
    LiveData<List<DataModel>> showAll();

    @Query("DELETE FROM DataTable")
    void deleteAll();


}
