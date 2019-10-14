package com.bethejustice.myrealtripmvp.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.bethejustice.myrealtripmvp.R;
import com.bethejustice.myrealtripmvp.view.add.AddActivity;
import com.bethejustice.myrealtripmvp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.fab.setOnClickListener(view -> startActivity(
                new Intent(this, AddActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)));
    }
}
