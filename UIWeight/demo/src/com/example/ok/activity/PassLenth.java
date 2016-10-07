package com.example.ok.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.csdn.Weight.EditText.PassView;
import com.csdn.Weight.EditText.PasswordInputView;
import com.example.ok.R;

public class PassLenth extends Activity implements View.OnClickListener {


    private com.csdn.Weight.EditText.PasswordInputView passwordInputView;
    private com.csdn.Weight.EditText.PassView idaeesl;
    private android.widget.Button ob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.pass_lenght);
        this.ob = (Button) findViewById(R.id.ob);
        this.idaeesl = (PassView) findViewById(R.id.idaeesl);
        this.passwordInputView = (PasswordInputView) findViewById(R.id.passwordInputView);

        this.ob.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ob) {
            Toast.makeText(this, passwordInputView.getText() + "", Toast.LENGTH_SHORT).show();
        }
    }
}
