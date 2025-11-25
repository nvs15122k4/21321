package com.example.lab9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LineChartActivity extends AppCompatActivity {
    private LineChartView lineChartView;
    private EditText etLine1, etLine2, etLine3, etLine4, etLine5, etLine6;
    private Button btnDrawLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        lineChartView = findViewById(R.id.lineChartView);
        etLine1 = findViewById(R.id.etLine1);
        etLine2 = findViewById(R.id.etLine2);
        etLine3 = findViewById(R.id.etLine3);
        etLine4 = findViewById(R.id.etLine4);
        etLine5 = findViewById(R.id.etLine5);
        etLine6 = findViewById(R.id.etLine6);
        btnDrawLine = findViewById(R.id.btnDrawLine);

        btnDrawLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float[] values = new float[6];
                    values[0] = Float.parseFloat(etLine1.getText().toString());
                    values[1] = Float.parseFloat(etLine2.getText().toString());
                    values[2] = Float.parseFloat(etLine3.getText().toString());
                    values[3] = Float.parseFloat(etLine4.getText().toString());
                    values[4] = Float.parseFloat(etLine5.getText().toString());
                    values[5] = Float.parseFloat(etLine6.getText().toString());

                    lineChartView.setValues(values);
                } catch (NumberFormatException e) {
                    Toast.makeText(LineChartActivity.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}