package com.example.firstprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    // Khai báo biến (từ ảnh 1)
    TextView txtNumber;
    ImageView imgDice;
    Button btnRoll;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        // Ánh xạ View (từ cả 2 ảnh)
        txtNumber = findViewById(R.id.txtNumber);
        imgDice = findViewById(R.id.imgDice);
        btnRoll = findViewById(R.id.btnRoll);

        // Xử lý sự kiện click nút (ghép từ cả 2 ảnh)
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo số ngẫu nhiên từ 1-6
                int number = random.nextInt(6) + 1;
                txtNumber.setText("Number: " + number);

                // Ánh xạ số với hình ảnh xúc xắc
                int diceImage = R.drawable.anh1; // Ảnh mặc định
                switch (number) {
                    case 1:
                        diceImage = R.drawable.anh1;
                        break;
                    case 2:
                        diceImage = R.drawable.anh2;
                        break;
                    case 3:
                        diceImage = R.drawable.anh3;
                        break;
                    case 4:
                        diceImage = R.drawable.anh4;
                        break;
                    case 5:
                        diceImage = R.drawable.anh5;
                        break;
                    case 6:
                        diceImage = R.drawable.anh6;
                        break;
                    default:
                        diceImage = R.drawable.anh6;
                        break;
                                    }

                // Hiển thị hình ảnh xúc xắc (từ ảnh 2)
                imgDice.setImageResource(diceImage);
            }
        });
    }
}

