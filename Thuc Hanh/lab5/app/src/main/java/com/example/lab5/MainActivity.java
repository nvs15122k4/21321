package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] anims = {R.anim.alpha, R.anim.rotate, R.anim.scale, R.anim.translate};
    private ImageView imgElephant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgElephant = findViewById(R.id.img_elephant);
        Button btnRandom = findViewById(R.id.btn_random);

        imgElephant.setOnClickListener(v -> playRandomAnimation());
        btnRandom.setOnClickListener(v -> playRandomAnimation());
    }

    private void playRandomAnimation() {
        int random = new Random().nextInt(anims.length);
        Animation animation = AnimationUtils.loadAnimation(this, anims[random]);
        imgElephant.startAnimation(animation);
    }
}
