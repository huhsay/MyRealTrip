package com.bethejustice.myrealtripmvp.view.add;

import androidx.annotation.NonNull;

import com.bethejustice.myrealtripmvp.data.AnimalRepository;
import com.bethejustice.myrealtripmvp.data.room.Animal;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class AddAnimalPresenter {

    @NonNull
    final private AnimalRepository repository;
    @NonNull
    final private CompositeDisposable compositeDisposable;
    @NonNull
    final private AddAnimalView addAnimalView;

    public AddAnimalPresenter(@NonNull AnimalRepository repository,
                              @NonNull AddAnimalView addAnimalView) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
        this.addAnimalView = addAnimalView;
    }

    void addAnimal(Animal animal) {
        compositeDisposable.add(repository.insert(animal)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                            addAnimalView.showMessage("저장되었습니다.");
                            addAnimalView.finishActivity(); },
                        throwable -> addAnimalView.showMessage("실패하였습니다.")));
    }

    void onViewPaused() {
        compositeDisposable.clear();
    }
}
