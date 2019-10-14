package com.bethejustice.myrealtripmvp.view.main;

import androidx.annotation.NonNull;

import com.bethejustice.myrealtripmvp.data.AnimalRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

class MainPresenter {

    @NonNull
    final private AnimalRepository repository;
    @NonNull
    final private CompositeDisposable compositeDisposable;
    @NonNull
    final private MainView mainView;

    MainPresenter(@NonNull AnimalRepository repository,
                  @NonNull MainView mainView) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
        this.mainView = mainView;
    }

    void getAnimal() {
        compositeDisposable.add(repository.getAll().observeOn(AndroidSchedulers.mainThread())
        .subscribe(mainView::setAnimal,
                throwable -> mainView.showError(0)));
    }

    void onViewPaused() {
        compositeDisposable.clear();
    }
}
