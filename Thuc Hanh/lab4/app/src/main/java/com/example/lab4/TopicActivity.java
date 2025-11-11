package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TopicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        Button btnFood = findViewById(R.id.btnFood);
        Button btnAnimal = findViewById(R.id.btnAnimal);

        btnFood.setOnClickListener(v -> {
            Toast.makeText(this, "Từ vựng: rice, bread, fish...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, WordListActivity.class);
            i.putExtra("topic", "food");
            startActivity(i);
        });

        btnAnimal.setOnClickListener(v -> {
            Toast.makeText(this, "Từ vựng: dog, cat, lion...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, WordListActivity.class);
            i.putExtra("topic", "animal");
            startActivity(i);
        });
    }
}
