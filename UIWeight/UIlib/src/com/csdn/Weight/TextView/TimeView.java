package com.csdn.Weight.TextView;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/8.
 */
public class TimeView extends TextView {
    private TimeCount timeCount;

    public TimeView(Context context) {
        this(context, null, 0);
    }

    public TimeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public void init(long time) {
        timeCount = new TimeCount(time, 1000);
        timeCount.start();
    }


    class TimeCount extends CountDownTimer {


        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String t = getTime(millisUntilFinished / 1000);
            TimeView.this.setText(t);
        }

        @Override
        public void onFinish() {
            TimeView.this.setText("00 : 00 : 00");
        }
        //将时间倒计时时间显示在textview中
        private String getTime(long second) {
            String mTime = "";
            if (second < 60) {
                mTime = "00 : 00 : " + formatData(second);
            } else if (second < 60 * 60) {
                mTime = "00 :" + formatData(second / 60) + " : " + formatData(second % 60);
            } else if (second < 60 * 60 * 24) {
                mTime = formatData(second / 3600) + " : " + formatData(second % 3600 / 60) + " : " + formatData(second % 3600 % 60);
            }
            return mTime;
        }

        //模式化数据，将个位数补零
        public String formatData(long second) {
            String s = Long.toString(second);
            if (second < 10) {
                s = "0" + s;
            }
            return s;
        }

    }
}
