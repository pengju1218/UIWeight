package com.csdn.Weight.Spinner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.csdn.Weight.R;
import com.csdn.Weight.adapter.ChooseItemAdatper;

import java.util.List;

public class ListPopWindow extends PopupWindow {
    private View conentView;
    private ListView listView;
    private Activity context;

    public ListPopWindow(final Activity context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.choose_pop, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        this.context=context;
       
        this.setContentView(conentView);
     
        this.setWidth(w / 2 + 50);
       
        this.setHeight(LayoutParams.WRAP_CONTENT);
    
        this.setFocusable(true);
        this.setOutsideTouchable(true);
       
        this.update();
      
        ColorDrawable dw = new ColorDrawable(0000000000);
     
        this.setBackgroundDrawable(dw);

        listView = (ListView) conentView.findViewById(R.id.lv_pop);

        
        //this.setAnimationStyle(R.style.AnimationPreview);

    }

    public void setAdatper(String[] strings) {
        if (listView != null) {
            ChooseItemAdatper chooseItemAdatper=new ChooseItemAdatper(context,0,strings);
            listView.setAdapter(chooseItemAdatper);
        }
    }


    public void setAdatper(List<String> strings) {
        if (listView != null) {
            ChooseItemAdatper chooseItemAdatper=new ChooseItemAdatper(context,0,strings);
            listView.setAdapter(chooseItemAdatper);
        }
    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent, parent.getLayoutParams().width / 2, 0);
        } else {
            this.dismiss();
        }
    }

    public void showPopuponView(View view) {
        if (!this.isShowing()) {
            this.setWidth(view.getWidth());
            this.showAsDropDown(view);
        } else {
            this.dismiss();
        }
    }
}
