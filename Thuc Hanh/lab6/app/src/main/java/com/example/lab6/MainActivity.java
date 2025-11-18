package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Spinner spnFrom, spnTo;
    EditText edtInput;
    TextView txtResult;
    Button btnConvert;

    String[] units = {
            "Hải lý",
            "Dặm",
            "Kilometer",
            "Lý",
            "Mét",
            "Yard",
            "Foot",
            "Inches"
    };

    // Đổi về mét
    double[] toMeter = {
            1852,
            1609.344,
            1000,
            500,
            1,
            0.9144,
            0.3048,
            0.0254
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnFrom = findViewById(R.id.spnFrom);
        spnTo = findViewById(R.id.spnTo);
        edtInput = findViewById(R.id.edtInput);
        txtResult = findViewById(R.id.txtResult);
        btnConvert = findViewById(R.id.btnConvert);

        // Spinner adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, units
        );
        spnFrom.setAdapter(adapter);
        spnTo.setAdapter(adapter);

        // Convert
        btnConvert.setOnClickListener(v -> {
            String s = edtInput.getText().toString();

            if (s.isEmpty()) {
                txtResult.setText("Vui lòng nhập số");
                return;
            }

            double input = Double.parseDouble(s);

            int from = spnFrom.getSelectedItemPosition();
            int to = spnTo.getSelectedItemPosition();

            double meterValue = input * toMeter[from];
            double result = meterValue / toMeter[to];

            txtResult.setText(input + " " + units[from] + " = " + result + " " + units[to]);
        });
    }
}
