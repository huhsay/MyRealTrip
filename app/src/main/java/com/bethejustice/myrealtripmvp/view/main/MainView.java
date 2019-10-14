package com.bethejustice.myrealtripmvp.view.main;

import androidx.annotation.NonNull;

import com.bethejustice.myrealtripmvp.data.room.Animal;

import java.util.List;

public interface MainView {

    void setAnimal(@NonNull List<Animal> animals);

    void showError(@NonNull int error);
}
