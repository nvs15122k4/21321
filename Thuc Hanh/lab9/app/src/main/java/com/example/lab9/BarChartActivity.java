package com.example.lab9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BarChartActivity extends AppCompatActivity {
    private BarChartView barChartView;
    private EditText etValue1, etValue2, etValue3, etValue4, etValue5;
    private Button btnDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        barChartView = findViewById(R.id.barChartView);
        etValue1 = findViewById(R.id.etValue1);
        etValue2 = findViewById(R.id.etValue2);
        etValue3 = findViewById(R.id.etValue3);
        etValue4 = findViewById(R.id.etValue4);
        etValue5 = findViewById(R.id.etValue5);
        btnDraw = findViewById(R.id.btnDraw);

        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float[] values = new float[5];
                    values[0] = Float.parseFloat(etValue1.getText().toString());
                    values[1] = Float.parseFloat(etValue2.getText().toString());
                    values[2] = Float.parseFloat(etValue3.getText().toString());
                    values[3] = Float.parseFloat(etValue4.getText().toString());
                    values[4] = Float.parseFloat(etValue5.getText().toString());

                    barChartView.setValues(values);
                } catch (NumberFormatException e) {
                    Toast.makeText(BarChartActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}