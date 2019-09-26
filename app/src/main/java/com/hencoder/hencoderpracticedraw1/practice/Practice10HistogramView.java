package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ArrayList<HistogramModel> list = new ArrayList<HistogramModel>();
    private float maxHeight = 500;
    private float maxRatio = 40;
    private float width = 100;
    private float space = 20;

    private void initData() {
        String[] names = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
        float[] ratios = {0.1f, 1.7f, 1.6f, 16.7f, 29.2f, 35.5f, 15.2f};
        for (int i = 0; i < names.length; i++) {
            HistogramModel model = new HistogramModel();
            model.setName(names[i]);
            model.setRatio(ratios[i]);
            list.add(model);
        }
    }

    private Paint paint = new Paint();


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        canvas.save();

        canvas.scale(1, -1);
        canvas.translate(100, -600);
//        canvas.scale(1, -1, 100, 600);

        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLine(0, maxHeight, 0, 0, paint);
        canvas.drawLine(0, 0, (width + space) * list.size() + space, 0, paint);

        float top = 0;
        float left = space;
        float right = left + width;
        float bottom = 0;
        for (HistogramModel model : list) {
            top = model.getRatio() / maxRatio * maxHeight;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#72b916"));
            canvas.drawRect(left, top, right, bottom, paint);

            left += width + space;
            right = left + width;

        }


        canvas.scale(1, -1);
        left = space;
        bottom = 0;
        for (HistogramModel model : list) {
            paint.setColor(Color.WHITE);
            paint.setTextSize(30);
            paint.setTextAlign(Paint.Align.CENTER);
            float x = left + width / 2;
            float y = 20;
            canvas.drawText(model.getName(), x, y, paint);
            left += width + space;
        }


        canvas.restore();

    }
}


class HistogramModel {
    private String name;
    private float ratio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}