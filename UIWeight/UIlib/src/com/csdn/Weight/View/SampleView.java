package com.csdn.Weight.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.view.View;

@SuppressLint("DrawAllocation")
public class SampleView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mRotate;
    private Matrix mMatrix = new Matrix();
    private Shader mShader;

    public SampleView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        float x = 550;
        float y = 700;
        //颜色代码
       /* mShader = new SweepGradient(x, y, new int[]{0xFF09F68C,
                0xFFB0F44B,
                0xFFE8DD30,
                0xFFF1CA2E,
                0xFFFF902F,
                0xFFFF6433}, null);*/

        //颜色代码
        /*mShader = new SweepGradient(0, 0, new int[]{0xFFFF0000,
                0xFF000000,0xFFB0F44B,
                0xFFE8DD30,
                0xFFF1CA2E,
                0xFFFF902F,
                0xFFFF6433}, null);*/
        //mMatrix.setRotate(165, x+getWidth()/2, y+getHeight()/2);

        mShader = new SweepGradient(x+getWidth()/2, y+getHeight()/2, new int[]{
                Color.parseColor("#DCDCDC"), Color.parseColor("#DCDCDC"),Color.parseColor("#746Df8"),
                Color.parseColor("#007DFF"),Color.parseColor("#8B7AF2"),Color.parseColor("#DCDCDC"),
                Color.parseColor("#DCDCDC"),Color.parseColor("#DCDCDC"),Color.parseColor("#DCDCDC"),Color.parseColor("#DCDCDC"),
                Color.parseColor("#DCDCDC")},null);
        mShader.setLocalMatrix(mMatrix);
        mPaint.setShader(mShader);
        mPaint.setStyle(Paint.Style.STROKE);
              /* DashPathEffect：
               * 这个类的作用就是将Path的线段虚线化。 构造函数为DashPathEffect(float[] intervals, float offset)，
               * 其中intervals为虚线的ON和OFF数组，该数组的length必须大于等于2，phase为绘制时的偏移量。*/
        PathEffect effect = new DashPathEffect(new float[]{10, 5, 10, 5}, 1);//第一个数为小长方形宽，第二个数为小长方形间的间隔，第三个和第一个第四个和第二个效果一样
        mPaint.setPathEffect(effect);
        mPaint.setStrokeWidth(60);//小长方形的长度,即弧的宽

    }

    public void getArc(Canvas canvas, float o_x, float o_y, float r,
                       float startangel, float endangel, Paint paint) {
        RectF rect = new RectF(o_x - r, o_y - r, o_x + r, o_y + r);
        Path path = new Path();
        path.moveTo(o_x, o_y);
        path.lineTo((float) (o_x + r * Math.cos(startangel * Math.PI / 180))
                , (float) (o_y + r * Math.sin(startangel * Math.PI / 180)));
        path.lineTo((float) (o_x + r * Math.cos(endangel * Math.PI / 180))
                , (float) (o_y + r * Math.sin(endangel * Math.PI / 180)));
        path.addArc(rect, startangel, endangel - startangel);
        canvas.clipPath(path);
        canvas.drawCircle(o_x, o_y, r, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = mPaint;//圆心位置
        float x = 550;
        float y = 700;

        canvas.drawColor(Color.WHITE);
       /* //颜色旋转代码
              mMatrix.setRotate(mRotate, x, y);0.
                mShader.setLocalMatrix(mMatrix);
                mRotate += 3;
                if (mRotate >= 360) {
                    mRotate = 0;
               }*/
        invalidate();
       // getArc(canvas, x, y, 290, -180, 360, paint);//第一个数字为半径，后面两个数字控制缺口



        canvas.drawCircle(x,y, 290, paint);

        Paint paint1=new Paint();
        paint1.setColor(Color.parseColor("#007DFF"));
        paint1.setStrokeWidth(9);
        paint1.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x,y, 340, paint1);
    }
}