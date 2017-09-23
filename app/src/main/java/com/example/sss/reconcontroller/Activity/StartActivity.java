package com.example.sss.reconcontroller.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.sss.reconcontroller.R;
import com.example.sss.reconcontroller.Utill.Contextor;

public class StartActivity extends AppCompatActivity {

    private ImageButton buttonStart;
    private ImageButton buttonSetting;
    private ImageButton buttonHow;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        Contextor.getInstance().init(getApplicationContext());

        Log.d("Log","in Start");
        initView();
        initListener();
    }

    public void initView(){
        buttonStart=(ImageButton)findViewById(R.id.buttonStart);
        buttonSetting=(ImageButton)findViewById(R.id.buttonSetting);
        buttonHow=(ImageButton)findViewById(R.id.buttonHow);
    }

    public void initListener(){

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(StartActivity.this,SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonHow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
