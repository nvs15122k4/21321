package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class QuickCallActivity extends AppCompatActivity implements View.OnClickListener {
    private int[] anims = {
            R.anim.alpha,
            R.anim.rotate,
            R.anim.scale,
            R.anim.translate
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quickcall);

        findViewById(R.id.fr_mom).setOnClickListener(this);
        findViewById(R.id.fr_dad).setOnClickListener(this);
        findViewById(R.id.fr_crush).setOnClickListener(this);
        findViewById(R.id.fr_best_friend).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int random = new Random().nextInt(anims.length);
        Animation animation = AnimationUtils.loadAnimation(this, anims[random]);
        v.startAnimation(animation);
    }
}
