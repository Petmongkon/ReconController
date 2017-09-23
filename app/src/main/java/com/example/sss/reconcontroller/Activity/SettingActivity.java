package com.example.sss.reconcontroller.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sss.reconcontroller.R;
import com.example.sss.reconcontroller.Utill.Constant;
import com.example.sss.reconcontroller.Utill.Preference;

public class SettingActivity extends AppCompatActivity {

    private Button buttonConnect;
    private Button buttonSave;
    private Button buttonCancle;
    private TextView textViewStatus;
    private EditText editTextIP;
    private EditText editTextPort;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initListener();
    }

    public void initView(){
        buttonConnect=(Button)findViewById(R.id.buttonConnect);
        buttonSave=(Button)findViewById(R.id.buttonSave);
        buttonCancle=(Button)findViewById(R.id.buttonCancle);
        textViewStatus=(TextView)findViewById(R.id.textViewStatus);
        editTextIP=(EditText)findViewById(R.id.editTextIP);
        editTextPort=(EditText)findViewById(R.id.editTextPort);
        editTextIP.setText(Preference.getInstance().Get(Constant.PI_IP));
        editTextPort.setText(Preference.getInstance().Get(Constant.PI_PORT));
    }

    public void initListener(){
        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(SettingActivity.this,StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Preference.getInstance().Save(Constant.PI_IP,editTextIP.getText().toString());
                Preference.getInstance().Save(Constant.PI_PORT,editTextPort.getText().toString());

                intent=new Intent(SettingActivity.this,StartActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
