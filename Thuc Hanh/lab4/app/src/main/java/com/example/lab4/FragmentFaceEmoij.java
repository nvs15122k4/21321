package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class FragmentFaceEmoij extends Fragment {
    int[] ids = {R.id.iv_face1, R.id.iv_face2, R.id.iv_face3, R.id.iv_face4, R.id.iv_face5,
            R.id.iv_face6, R.id.iv_face7, R.id.iv_face8, R.id.iv_face9};
    int[] icons = {
            R.drawable.ic_angry, R.drawable.ic_baffle, R.drawable.ic_beauty,
            R.drawable.ic_boss, R.drawable.ic_choler, R.drawable.ic_dribble,
            R.drawable.ic_look_down, R.drawable.ic_sure, R.drawable.ic_tire, R.drawable.ic_love
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.m001_frg_face_emoij, container, false);
        Button btnRandom = v.findViewById(R.id.btn_random);
        Random rnd = new Random();

        btnRandom.setOnClickListener(b -> {
            for (int id : ids) {
                ImageView iv = v.findViewById(id);
                int randIndex = rnd.nextInt(icons.length);
                iv.setImageResource(icons[randIndex]);
            }
        });

        return v;
    }
}
