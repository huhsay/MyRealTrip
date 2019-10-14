package com.bethejustice.myrealtripmvp.data;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;


import com.bethejustice.myrealtripmvp.data.room.Animal;
import com.bethejustice.myrealtripmvp.data.room.AnimalDao;
import com.bethejustice.myrealtripmvp.data.room.AnimalDatabase;

import java.util.Arrays;
import java.util.List;

public class AnimalRepository {

    private static final String TAG = "AnimalRepository";
    private static AnimalRepository INSTANCE;
    static private AnimalDao animalDao;

    private AnimalRepository(Context context) {
        AnimalDatabase animalDatabase = AnimalDatabase.getInstance(context);
        animalDao = animalDatabase.animalDao();
    }

    @NonNull
    public static AnimalRepository getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AnimalRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AnimalRepository(context);
                }
            }
        }
        return INSTANCE;
    }

    public void insert(Animal animal) {
        try {
            Thread thread = new Thread(() -> animalDao.insert(animal));
            thread.start();

        } catch (Exception e) {
            Log.d(TAG, "insert: " + Arrays.toString(e.getStackTrace()));
        }
    }

    public List<Animal> getAll() {
        return animalDao.getAll();
    }

}
