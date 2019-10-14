package com.bethejustice.myrealtripmvp.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert
    void insert(Animal animal);

    @Query("SELECT * FROM animals")
    List<Animal> getAll();

}
