package com.example.lab3;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        TextView tvVi = findViewById(R.id.tvVi);
        TextView tvEn = findViewById(R.id.tvEn);
        TextView tvFr = findViewById(R.id.tvFr);

        tvVi.setOnClickListener(v -> setLocale("vi"));
        tvEn.setOnClickListener(v -> setLocale("en"));
        tvFr.setOnClickListener(v -> setLocale("fr"));
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        Intent refresh = new Intent(this, LanguageActivity.class);
        finish();
        startActivity(refresh);
    }
}
