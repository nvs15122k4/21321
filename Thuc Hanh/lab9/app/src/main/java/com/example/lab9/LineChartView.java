package com.example.lab9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LineChartView extends View {
    private float[] values = {3, 6, 8, 7, 2, 3};
    private Paint linePaint;
    private Paint textPaint;
    private Paint axisPaint;

    public LineChartView(Context context) {
        super(context);
        init();
    }

    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.CYAN);
        linePaint.setStrokeWidth(8f);
        linePaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.CYAN);
        textPaint.setTextSize(40f);
        textPaint.setTextAlign(Paint.Align.CENTER);

        axisPaint = new Paint();
        axisPaint.setAntiAlias(true);
        axisPaint.setColor(Color.WHITE);
        axisPaint.setStrokeWidth(3f);
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
        int padding = 100;
        int chartHeight = height - 2 * padding;
        int chartWidth = width - 2 * padding;

        float maxValue = 0;
        for (float value : values) {
            if (value > maxValue) maxValue = value;
        }

        canvas.drawLine(padding, height - padding, width - padding, height - padding, axisPaint);
        canvas.drawLine(padding, padding, padding, height - padding, axisPaint);

        float stepX = (float) chartWidth / (values.length - 1);

        for (int i = 0; i < values.length - 1; i++) {
            float x1 = padding + i * stepX;
            float y1 = height - padding - (values[i] / maxValue) * chartHeight;
            float x2 = padding + (i + 1) * stepX;
            float y2 = height - padding - (values[i + 1] / maxValue) * chartHeight;

            canvas.drawLine(x1, y1, x2, y2, linePaint);

            canvas.drawText(String.valueOf((int) values[i]), x1, y1 - 20, textPaint);
        }

        canvas.drawText(String.valueOf((int) values[values.length - 1]),
                padding + (values.length - 1) * stepX,
                height - padding - (values[values.length - 1] / maxValue) * chartHeight - 20,
                textPaint);

        textPaint.setTextSize(50f);
        canvas.drawText("POWER NOW:", width / 2, 100, textPaint);
        textPaint.setTextSize(120f);
        canvas.drawText("250W", width / 2, 220, textPaint);
        textPaint.setTextSize(30f);
        canvas.drawText("USE TODAY: 0.5 kWh", width / 2, 270, textPaint);
    }
}