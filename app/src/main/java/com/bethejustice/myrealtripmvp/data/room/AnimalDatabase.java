package com.bethejustice.myrealtripmvp.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Animal.class}, version = 1, exportSchema = false)
@TypeConverters({AnimalTypeConverter.class})
public abstract class AnimalDatabase extends RoomDatabase {

    public abstract AnimalDao animalDao();
    static private AnimalDatabase INSTANCE;

    public static AnimalDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AnimalDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context, AnimalDatabase.class, "animals")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
