package com.bethejustice.myrealtripmvp.data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bethejustice.myrealtripmvp.data.room.Animal;
import com.bethejustice.myrealtripmvp.data.room.AnimalDao;
import com.bethejustice.myrealtripmvp.data.room.AnimalDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

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

    public Completable insert(Animal animal) {
        return Completable.fromAction(() -> animalDao.insert(animal)).subscribeOn(Schedulers.io());
    }

    public Single<List<Animal>> getAll() {
        return animalDao.getAll().subscribeOn(Schedulers.io());
    }

}
