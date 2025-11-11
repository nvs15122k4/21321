package com.example.firstprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtX, txtY;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMultiply, btnDivide, btnModulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }

    private void initControl() {
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnModulo = findViewById(R.id.btnModulo);

        // Sửa lỗi cú pháp: loại bỏ 'operator:'
        btnPlus.setOnClickListener(v -> performOperation('+'));
        btnMinus.setOnClickListener(v -> performOperation('-'));
        btnMultiply.setOnClickListener(v -> performOperation('*'));
        btnDivide.setOnClickListener(v -> performOperation('/'));
        btnModulo.setOnClickListener(v -> performOperation('%'));
    }

    private void performOperation(char operator) {
        try {
            String xStr = txtX.getText().toString();
            String yStr = txtY.getText().toString();

            // Sửa lỗi cú pháp: loại bỏ 'context:' và 'text:'
            if (xStr.isEmpty() || yStr.isEmpty()) {
                Toast.makeText(this, "Please enter both X and Y", Toast.LENGTH_SHORT).show();
                return;
            }

            double x = Double.parseDouble(xStr);
            double y = Double.parseDouble(yStr);
            double result = 0;

            switch (operator) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '/':
                    if (y == 0) {
                        // Sửa lỗi cú pháp: loại bỏ 'context:' và 'text:'
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = x / y; // Bổ sung phần còn thiếu
                    break; // Bổ sung phần còn thiếu

                // Bổ sung case '%' cho btnModulo
                case '%':
                    if (y == 0) {
                        Toast.makeText(this, "Cannot modulo by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = x % y;
                    break;
            }

            // Hiển thị kết quả với 2 chữ số thập phân
            txtResult.setText(String.format("%.2f", result));

        } catch (NumberFormatException e) {
            // Bắt lỗi nếu người dùng nhập không phải là số
            Toast.makeText(this, "Invalid input. Please enter numbers.", Toast.LENGTH_SHORT).show();
        }
    }
}