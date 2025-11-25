package com.example.lab9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieChartView extends View {
    private float[] values = {450, 1230, 200, 400};
    private String[] labels = {"450.0", "1230.0", "200.0", "400.0"};
    private int[] colors = {
            Color.GREEN,
            Color.BLUE,
            Color.RED,
            Color.YELLOW
    };
    private Paint paint;
    private Paint textPaint;

    public PieChartView(Context context) {
        super(context);
        init();
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(40f);
        textPaint.setTextAlign(Paint.Align.LEFT);
    }

    public void setValues(float[] values) {
        this.values = values;
        this.labels = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            labels[i] = String.valueOf(values[i]);
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (values == null || values.length == 0) return;

        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height) - 200;
        int centerX = width / 2;
        int centerY = height / 2 - 50;

        RectF rectF = new RectF(
                centerX - size / 2,
                centerY - size / 2,
                centerX + size / 2,
                centerY + size / 2
        );

        float total = 0;
        for (float value : values) {
            total += value;
        }

        float startAngle = 0;
        for (int i = 0; i < values.length; i++) {
            float sweepAngle = (values[i] / total) * 360;
            paint.setColor(colors[i % colors.length]);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
            startAngle += sweepAngle;
        }

        int legendY = height - 150;
        int legendX = 50;
        int boxSize = 40;

        for (int i = 0; i < values.length; i++) {
            paint.setColor(colors[i % colors.length]);
            canvas.drawRect(legendX, legendY + i * 50, legendX + boxSize, legendY + i * 50 + boxSize, paint);
            canvas.drawText(labels[i], legendX + boxSize + 20, legendY + i * 50 + 30, textPaint);
        }

        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(30f);
        canvas.drawText("Pie chart key generated via onDrawFinished()", width / 2, height - 30, textPaint);
    }
}