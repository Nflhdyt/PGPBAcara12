package com.example.acara12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.acara12.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prefManager = PrefManager.getInstance(this);
        checkLoginStatus();

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setLoggedIn(false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void checkLoginStatus(){
        boolean isLoggedIn = prefManager.isLoggedIn();
        if (!isLoggedIn){
            startActivity(new Intent(MainActivity.this,
                    LoginActivity.class));
            finish();
 }
}
}