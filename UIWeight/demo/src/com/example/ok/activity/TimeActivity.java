package com.example.ok.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.csdn.Weight.TextView.TimeView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;

public class TimeActivity extends BaseActivity implements View.OnClickListener {



    private android.widget.ListView lste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_layout);
        this.lste = (ListView) findViewById(R.id.lste);
        lste.setAdapter(new MyAdpater());
    }

    @Override
    public void onClick(View v) {

    }
    class MyAdpater extends BaseAdapter {

        public int getCount() {
            // TODO Auto-generated method stub
            return 10;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(TimeActivity.this).inflate(
                        R.layout.time_itme, null);

                convertView.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.txt = (TimeView) convertView.findViewById(R.id.iese);

            viewHolder.txt.init(8*1000);
            // viewHolder.txt.reStart();
            //  viewHolder.txt.setPool(100);
            // viewHolder.txt.beginRun();
            return convertView;
        }

        class ViewHolder {
            TimeView txt;
        }

    }
}
