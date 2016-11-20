package com.example.ok.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.csdn.Weight.ImageView.RoundImageView;
import com.csdn.Weight.ListView.HorizontalListView;
import com.example.ok.Base.BaseActivity;
import com.example.ok.R;


public class HortalListView extends BaseActivity implements View.OnClickListener {


    private HorizontalListView listView;
    private int[] imags={R.drawable.listv_01,R.drawable.listv_02,R.drawable.listv_03,R.drawable.listv_05,
            R.drawable.listv_06,R.drawable.listv_07,R.drawable.listv_08,R.drawable.listv_09,R.drawable.listv_10,
            R.drawable.listv_11,R.drawable.listv_01,R.drawable.listv_02,R.drawable.listv_03,R.drawable.listv_05,
            R.drawable.listv_06,R.drawable.listv_07,R.drawable.listv_08,R.drawable.listv_09,R.drawable.listv_10,
            R.drawable.listv_11,R.drawable.listv_01,R.drawable.listv_02,R.drawable.listv_03,R.drawable.listv_05,
            R.drawable.listv_06,R.drawable.listv_07,R.drawable.listv_08,R.drawable.listv_09,R.drawable.listv_10,
            R.drawable.listv_11};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hor_listview);
        this.listView = (HorizontalListView) findViewById(R.id.listView);
        listView.setAdapter(new HAdapter());
    }

    @Override
    public void onClick(View v) {

    }

    private class  HAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return imags.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(convertView==null){
                viewHolder=new ViewHolder();
                convertView= LayoutInflater.from(HortalListView.this).inflate(R.layout.hor_item,null);
                viewHolder.img=(RoundImageView)convertView.findViewById(R.id.ok_img);
                convertView.setTag(viewHolder);
            }
            viewHolder=(ViewHolder)convertView.getTag();


            viewHolder.img.setImageResource(imags[position]);

            return convertView;
        }


        class ViewHolder{
            RoundImageView img;
        }
    }
}
