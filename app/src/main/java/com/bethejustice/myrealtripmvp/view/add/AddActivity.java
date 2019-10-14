package com.bethejustice.myrealtripmvp.view.add;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.bethejustice.myrealtripmvp.AnimalType;
import com.bethejustice.myrealtripmvp.R;
import com.bethejustice.myrealtripmvp.data.AnimalRepository;
import com.bethejustice.myrealtripmvp.data.room.Animal;
import com.bethejustice.myrealtripmvp.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity implements AddAnimalView {

    private ActivityAddBinding binding;
    private AddAnimalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add);

        binding.btAdd.setOnClickListener(view -> {
                    if(binding.evAnimalName.getText().toString().equals("")) {
                        showMessage(getString(R.string.mss_name_blank));
                        return;
                    }
                    addAnimal(new Animal(AnimalType.fromString(binding.spAnimalType.getSelectedItem().toString()),
                            binding.evAnimalName.getText().toString()));
                    finish();
                }
        );

        binding.btCancel.setOnClickListener(view -> finish());

        presenter = new AddAnimalPresenter(AnimalRepository.getInstance(this), this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void addAnimal(@NonNull Animal animal) {
        presenter.addAnimal(animal);
    }

    @Override
    public void showMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
