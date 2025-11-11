package com.example.lab4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class EmojiActivity extends AppCompatActivity {
    int[] icons = {
            R.drawable.ic_angry, R.drawable.ic_baffle, R.drawable.ic_beauty,
            R.drawable.ic_boss, R.drawable.ic_choler, R.drawable.ic_dribble,
            R.drawable.ic_look_down, R.drawable.ic_sure, R.drawable.ic_tire, R.drawable.ic_check
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);

        ImageView img = findViewById(R.id.imgEmoji);
        Button btn = findViewById(R.id.btnRandom);

        btn.setOnClickListener(v -> {
            int r = new Random().nextInt(icons.length);
            img.setImageResource(icons[r]);
        });
    }
}
