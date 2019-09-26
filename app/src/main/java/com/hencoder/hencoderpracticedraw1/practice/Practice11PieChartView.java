package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ArrayList<PieModel> list = new ArrayList<PieModel>();
    private void initData() {
        String[] names = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
        float[] ratios = {0.1f, 1.7f, 1.6f, 16.7f, 29.2f, 35.5f, 15.2f};
        String[] colors = {"#506e7a", "#9c27B0", "#9e9e9e", "#009688", "#2196f3", "#f44336", "#ffc107"};
        for (int i = 0; i < names.length; i++) {
            PieModel model = new PieModel();
            model.setName(names[i]);
            model.setRatio(ratios[i]);
            model.setColor(Color.parseColor(colors[i]));
            list.add(model);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图



        Paint paint = new Paint();
        PieModel model = null;
        float startAngle = 0f;
        float sweepAngle = 0f;
        float spaceAngle = 0f;
        RectF rectF = new RectF(20, 20, 420, 420);

        for (int i = 0;i < list.size(); i++) {

            model = list.get(i);
            paint.setColor(model.getColor());
            sweepAngle = model.getRatio() * 360 / 100f;


            canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);

            startAngle += sweepAngle + spaceAngle;
        }


    }
}


class PieModel {
    private String name;
    private float ratio;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

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