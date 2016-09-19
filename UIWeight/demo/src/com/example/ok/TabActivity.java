package com.example.ok;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.csdn.Weight.HorizontalScrollView.TabLine;
import com.example.ok.Base.BaseActivity;

public class TabActivity extends BaseActivity implements View.OnClickListener {
    private TabLine eeewa;
    private String[] aeea={"ee","bb","ee","bb","ee","bb","ee","bb"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_1);
        this.eeewa = (TabLine) findViewById(R.id.eeewa);
        eeewa.setName(aeea);
        eeewa.setOnSelectTabIndex(0);
        eeewa.setOnSelectListener(new TabLine.OnSelectListener() {
            @Override
            public void select(int index) {
                Toast.makeText(TabActivity.this,index+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
