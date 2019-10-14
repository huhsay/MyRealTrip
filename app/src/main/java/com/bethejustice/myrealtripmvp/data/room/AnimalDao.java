package com.bethejustice.myrealtripmvp.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;


@Dao
public interface AnimalDao {
    @Insert
    public void insert(Animal animal);

    @Query("SELECT * FROM animals ORDER BY id DESC")
    public Single<List<Animal>> getAll();

}
