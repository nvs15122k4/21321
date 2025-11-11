package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] topicIcons = {
            R.drawable.ic_mess, R.drawable.ic_flight,
            R.drawable.ic_hospital, R.drawable.ic_hotel, R.drawable.ic_restaurant
    };
    private String[] topicNames = {"Essentials", "Travel", "Hospital", "Hotel", "Restaurant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout lnMain = findViewById(R.id.ln_main);

        LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < topicNames.length; i++) {
            View item = inflater.inflate(R.layout.item_topic, lnMain, false);
            ImageView img = item.findViewById(R.id.iv_topic);
            TextView tv = item.findViewById(R.id.tv_topic);

            img.setImageResource(topicIcons[i]);
            tv.setText(topicNames[i]);

            int index = i;
            item.setOnClickListener(v -> {
                Toast.makeText(this, "Chủ đề: " + topicNames[index], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, WordListActivity.class);
                intent.putExtra("topic", topicNames[index]);
                startActivity(intent);
            });

            lnMain.addView(item);
        }
    }
}
