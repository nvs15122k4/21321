package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

public class SeekBarActivity extends AppCompatActivity {

    SeekBar seekR, seekG, seekB;
    TextView txtR, txtG, txtB;
    View viewRGB, viewCMY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        seekR = findViewById(R.id.seekR);
        seekG = findViewById(R.id.seekG);
        seekB = findViewById(R.id.seekB);

        txtR = findViewById(R.id.txtR);
        txtG = findViewById(R.id.txtG);
        txtB = findViewById(R.id.txtB);

        viewRGB = findViewById(R.id.viewRGB);
        viewCMY = findViewById(R.id.viewCMY);

        updateColor();

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seek, int value, boolean b) {
                txtR.setText("R = " + seekR.getProgress());
                txtG.setText("G = " + seekG.getProgress());
                txtB.setText("B = " + seekB.getProgress());
                updateColor();
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        };

        seekR.setOnSeekBarChangeListener(listener);
        seekG.setOnSeekBarChangeListener(listener);
        seekB.setOnSeekBarChangeListener(listener);
    }

    private void updateColor() {
        int R = seekR.getProgress();
        int G = seekG.getProgress();
        int B = seekB.getProgress();

        // RGB
        viewRGB.setBackgroundColor(Color.rgb(R, G, B));

        // CMY
        int C = 255 - R;
        int M = 255 - G;
        int Y = 255 - B;

        viewCMY.setBackgroundColor(Color.rgb(C, M, Y));
    }
}
