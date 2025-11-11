package com.example.lab3;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Switch switchOrientation;
    Button btnLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchOrientation = findViewById(R.id.switchOrientation);
        btnLanguage = findViewById(R.id.btnLanguage);

        switchOrientation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
                else
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });

        btnLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
            startActivity(intent);
        });
    }
}
