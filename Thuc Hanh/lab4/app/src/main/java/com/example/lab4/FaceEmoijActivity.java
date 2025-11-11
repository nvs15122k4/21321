package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class FaceEmoijActivity extends AppCompatActivity {

    private int[] faceIcons = {
            R.drawable.ic_angry, R.drawable.ic_baffle, R.drawable.ic_beauty,
            R.drawable.ic_boss, R.drawable.ic_choler, R.drawable.ic_dribble,
            R.drawable.ic_look_down, R.drawable.ic_sure, R.drawable.ic_tire, R.drawable.ic_love
    };

    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_emoji);

        gridLayout = findViewById(R.id.grid_faces);
        findViewById(R.id.btn_random).setOnClickListener(v -> showRandomIcons());
    }

    private void showRandomIcons() {
        gridLayout.removeAllViews();
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(faceIcons[random.nextInt(faceIcons.length)]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 200;
            params.height = 200;
            params.setMargins(8, 8, 8, 8);
            gridLayout.addView(img, params);
        }
    }
}
