package com.example.homewrecker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface LiveTaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(LiveTask liveTask);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(LiveTask liveTask);

    @Delete
    void delete(LiveTask liveTask);

    @Query("DELETE FROM livetask_table")
    void deleteAll();

    @Query("SELECT * FROM livetask_table ORDER BY priority DESC")
    LiveData<ArrayList<LiveTask>> getAllTasks();
}
