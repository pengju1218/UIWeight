package com.csdn.Weight.EditText;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.csdn.Weight.R;


public class PassView extends EditText{
    private int textLength;

    private int borderColor;
    private float borderWidth;
    private float borderRadius;

    private int passwordLength;
    private int passwordColor;
    private float passwordWidth;
  //  private float passwordRadius;

    private Paint passwordPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private final int defaultSplitLineWidth = 1;

    public PassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        final Resources res = getResources();

        final int defaultBorderColor = res.getColor(R.color.gray);
        final float defaultBorderWidth = res.getDimension(R.dimen.size_divier);
        final float defaultBorderRadius = res.getDimension(R.dimen.margin_actionsheet_left_right);
        final int defaultPasswordLength = 6;
        final int defaultPasswordColor = res.getColor(R.color.dimgrey);
        final float defaultPasswordWidth = res.getDimension(R.dimen.margin_actionsheet_left_right);
        final float defaultPasswordRadius = res.getDimension(R.dimen.height_alert_title);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PasswordView, 0, 0);
        try {
            borderColor = a.getColor(R.styleable.PasswordView_pass2_borderColor, defaultBorderColor);
            borderWidth = a.getDimension(R.styleable.PasswordView_pass2_borderWidth, defaultBorderWidth);
            borderRadius = a.getDimension(R.styleable.PasswordView_pass2_borderRadius, defaultBorderRadius);
            passwordLength = a.getInt(R.styleable.PasswordView_pass2_passwordLength, defaultPasswordLength);
            passwordColor = a.getColor(R.styleable.PasswordView_pass2_passwordColor, defaultPasswordColor);
            passwordWidth = a.getDimension(R.styleable.PasswordView_pass2_passwordWidth, defaultPasswordWidth);
           // passwordRadius = a.getDimension(R.styleable.PasswordView_pass2_passwordRadius, defaultPasswordRadius);
        } finally {
            a.recycle();
        }

        borderPaint.setStrokeWidth(borderWidth);
        borderPaint.setColor(borderColor);
        passwordPaint.setStrokeWidth(passwordWidth);
        passwordPaint.setStyle(Paint.Style.FILL);
        passwordPaint.setColor(passwordColor);

        setSingleLine(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        // 分割线
        borderPaint.setColor(borderColor);
        borderPaint.setStrokeWidth(defaultSplitLineWidth);
        for (int i = 1; i < passwordLength; i++) {
            float x = width * i / passwordLength;
            canvas.drawLine(x, 0, x, height, borderPaint);
        }

        // 密码
        float cx, cy = height/ 2;
        float half = width / passwordLength / 2;
        for(int i = 0; i < textLength; i++) {
            cx = width * i / passwordLength + half;
            canvas.drawCircle(cx, cy, passwordWidth, passwordPaint);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        this.textLength = text.toString().length();
        invalidate();
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        borderPaint.setColor(borderColor);
        invalidate();
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        borderPaint.setStrokeWidth(borderWidth);
        invalidate();
    }

    public float getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(float borderRadius) {
        this.borderRadius = borderRadius;
        invalidate();
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
        invalidate();
    }

    public int getPasswordColor() {
        return passwordColor;
    }

    public void setPasswordColor(int passwordColor) {
        this.passwordColor = passwordColor;
        passwordPaint.setColor(passwordColor);
        invalidate();
    }

    public float getPasswordWidth() {
        return passwordWidth;
    }

    public void setPasswordWidth(float passwordWidth) {
        this.passwordWidth = passwordWidth;
        passwordPaint.setStrokeWidth(passwordWidth);
        invalidate();
    }
/*
    public float getPasswordRadius() {
        return passwordRadius;
    }

    public void setPasswordRadius(float passwordRadius) {
        this.passwordRadius = passwordRadius;
        invalidate();
    }*/
}