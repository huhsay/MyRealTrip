package com.bethejustice.myrealtripmvp.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bethejustice.myrealtripmvp.R;
import com.bethejustice.myrealtripmvp.data.AnimalRepository;
import com.bethejustice.myrealtripmvp.data.room.Animal;
import com.bethejustice.myrealtripmvp.view.add.AddActivity;
import com.bethejustice.myrealtripmvp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private ActivityMainBinding binding;
    private AnimalAdapter animalAdapter;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.fab.setOnClickListener(view -> startActivity(
                new Intent(this, AddActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)));

        presenter = new MainPresenter(AnimalRepository.getInstance(this), this);

        animalAdapter = new AnimalAdapter();
        animalAdapter.setOnClickListener(type -> {
            if(type.getSound() == null) return;
            showMessage(type.getSound());
        });

        binding.rvAnimals.setLayoutManager(new LinearLayoutManager(this));
        binding.rvAnimals.setAdapter(animalAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getAnimal();
    }

    @Override
    public void setAnimal(@NonNull List<Animal> animal) {
        if(animal.isEmpty()){
            binding.tvNoData.setVisibility(View.VISIBLE);
            binding.rvAnimals.setVisibility(View.INVISIBLE);
        } else {
            binding.rvAnimals.setVisibility(View.VISIBLE);
            binding.tvNoData.setVisibility(View.INVISIBLE);
            animalAdapter.addItem(animal);
        }
    }

    public void showMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        showMessage(error);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onViewPaused();
    }
}
