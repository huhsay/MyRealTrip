package com.bethejustice.myrealtripmvp.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bethejustice.myrealtripmvp.AnimalType;

@Entity(tableName = "animals")
public class Animal {

    public Animal(AnimalType animal_type, String animal_name) {
        this.animal_type = animal_type;
        this.animal_name = animal_name;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "animal_type")
    public AnimalType animal_type;

    @ColumnInfo(name = "animal_name")
    public String animal_name;
}
