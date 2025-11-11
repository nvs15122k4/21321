package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class WordListActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnEmoji;

    private HashMap<String, String[]> topicWords = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        listView = findViewById(R.id.listView);
        btnEmoji = findViewById(R.id.btnEmoji);

        // ✅ Lấy chủ đề được chọn từ MainActivity
        String topic = getIntent().getStringExtra("topic");

        // ✅ Tạo dữ liệu các từ vựng theo chủ đề
        topicWords.put("Essentials", new String[]{"hello", "goodbye", "please", "thank you"});
        topicWords.put("Travel", new String[]{"plane", "ticket", "passport", "airport"});
        topicWords.put("Hospital", new String[]{"doctor", "nurse", "medicine", "patient"});
        topicWords.put("Hotel", new String[]{"room", "reception", "key", "reservation"});
        topicWords.put("Restaurant", new String[]{"menu", "waiter", "bill", "table"});

        // ✅ Lấy danh sách từ theo chủ đề được chọn
        String[] words = topicWords.getOrDefault(topic, new String[]{"Không có dữ liệu"});

        // ✅ Hiển thị lên ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, words);
        listView.setAdapter(adapter);

        // ✅ Khi bấm vào 1 từ → hiện Toast
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String word = words[position];
            Toast.makeText(this, "Từ: " + word, Toast.LENGTH_SHORT).show();
        });

        // ✅ Nút sang màn hình icon (Bài 3)
        btnEmoji.setOnClickListener(v -> {
            Intent intent = new Intent(this, FaceEmoijActivity.class);
            startActivity(intent);
        });
    }
}
