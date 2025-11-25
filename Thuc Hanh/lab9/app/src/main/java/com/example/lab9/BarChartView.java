package com.example.lab9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BarChartView extends View {
    private float[] values = {100, 200, 80, 180, 250};
    private int[] colors = {
            Color.rgb(153, 102, 255),
            Color.rgb(100, 200, 255),
            Color.rgb(128, 128, 128),
            Color.rgb(100, 200, 100),
            Color.rgb(100, 150, 255),
    };
    private Paint paint;

    public BarChartView(Context context) {
        super(context);
        init();
    }

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public void setValues(float[] values) {
        this.values = values;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (values == null || values.length == 0) return;

        int width = getWidth();
        int height = getHeight();
        int padding = 50;
        int chartHeight = height - 2 * padding;
        int chartWidth = width - 2 * padding;

        float maxValue = 0;
        for (float value : values) {
            if (value > maxValue) maxValue = value;
        }

        int barWidth = chartWidth / values.length;
        int barSpacing = barWidth / 5;
        int actualBarWidth = barWidth - barSpacing;

        for (int i = 0; i < values.length; i++) {
            float barHeight = (values[i] / maxValue) * chartHeight;
            float left = padding + i * barWidth + barSpacing / 2;
            float top = height - padding - barHeight;
            float right = left + actualBarWidth;
            float bottom = height - padding;

            paint.setColor(colors[i % colors.length]);
            canvas.drawRect(left, top, right, bottom, paint);
        }
    }
}