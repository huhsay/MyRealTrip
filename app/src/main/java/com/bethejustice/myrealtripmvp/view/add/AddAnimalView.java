package com.bethejustice.myrealtripmvp.view.add;

import androidx.annotation.NonNull;

import com.bethejustice.myrealtripmvp.data.room.Animal;

public interface AddAnimalView {

    void addAnimal(@NonNull Animal animal);

    void showMessage(@NonNull String message);
}
