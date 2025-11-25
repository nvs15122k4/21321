package com.example.lab9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PieChartActivity extends AppCompatActivity {
    private PieChartView pieChartView;
    private EditText etPie1, etPie2, etPie3, etPie4;
    private Button btnDrawPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        pieChartView = findViewById(R.id.pieChartView);
        etPie1 = findViewById(R.id.etPie1);
        etPie2 = findViewById(R.id.etPie2);
        etPie3 = findViewById(R.id.etPie3);
        etPie4 = findViewById(R.id.etPie4);
        btnDrawPie = findViewById(R.id.btnDrawPie);

        btnDrawPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float[] values = new float[4];
                    values[0] = Float.parseFloat(etPie1.getText().toString());
                    values[1] = Float.parseFloat(etPie2.getText().toString());
                    values[2] = Float.parseFloat(etPie3.getText().toString());
                    values[3] = Float.parseFloat(etPie4.getText().toString());

                    pieChartView.setValues(values);
                } catch (NumberFormatException e) {
                    Toast.makeText(PieChartActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}