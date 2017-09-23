package com.example.sss.reconcontroller.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.erz.joysticklibrary.JoyStick;
import com.example.sss.reconcontroller.R;
import com.example.sss.reconcontroller.Utill.ConnectionClass;

public class MainActivity extends AppCompatActivity {

    private JoyStick joyStick;
    private String text;
    private ConnectionClass connectionClass;
    private String temp = "99";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Log","In main");
        initView();
        initListener();

    }

    public void initView(){
        joyStick=(JoyStick)findViewById(R.id.joy);
    }

    public void initListener(){
        joyStick.setListener(new JoyStick.JoyStickListener() {
            @Override
            public void onMove(JoyStick joyStick, double angle, double power, int direction) {
                int k = joyStick.getDirection();
                switch (k){
                    case -1:
                        text = "S";
                        break;
                    case 0:
                        text = "A";
                        break;
                    case 1:
                        text = "Q";
                        break;
                    case 2:
                        text = "W";
                        break;
                    case 3:
                        text = "E";
                        break;
                    case 4:
                        text = "D";
                        break;
                    case 5:
                        text = "C";
                        break;
                    case 6:
                        text = "X";
                        break;
                    case 7:
                        text = "Z";
                        break;
                }

                System.out.println(temp+" "+k+" "+text);

                if(!text.equalsIgnoreCase(temp)){
                    connectionClass=new ConnectionClass(text);
                    System.out.println(text);
                    connectionClass.execute();
                    temp=text;
                }
            }

            @Override
            public void onTap() {

            }

            @Override
            public void onDoubleTap() {

            }
        });
    }
}
