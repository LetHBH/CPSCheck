package com.example.cpscheck;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import utils.CountDown;
import utils.CountDownListener;
import utils.setInfo;

public class soloActivity extends AppCompatActivity implements CountDownListener {
    setInfo set = new setInfo();
    boolean Switch = true;
    int points = 0;
    double cps;
    TextView cpstext;
    TextView pointstext;
    Button button;
    TextView time;
    private CountDown countDown;

    //初始化所有组件
    private void initViews() {
        button = findViewById(R.id.button1);
        cpstext = findViewById(R.id.CPS);
        pointstext = findViewById(R.id.points);
        time = findViewById(R.id.time);
    }

    //将按钮逻辑及监听器放在同一个方法里
    private void onButtonClick() {
        CountDown cd = new CountDown(11000, 1000, this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Switch == true) {
                    points = 0;
                    cps = 0.0;

                    cpstext.setText("CPS:" + cps);
                    pointstext.setText("分数:" + points);

                    cd.start();
                    points++;
                    pointstext.setText("分数:" + points);
                } else {
                    points++;
                    pointstext.setText("分数:" + points);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);
        initViews();
        onButtonClick();    //按钮注册监听器
        Log.d("LLL", "页面启动");
    }

    @Override
    public void onSecondsRemaining(long seconds) {
        Switch = false;
        time.setText("Tiem:" + seconds);
    }

    @Override
    public void onCountdownFinished() {
        // 设置按钮不可点击
        set.setButton(button, 4000);

        cps = (double) points / 10;

        cpstext.setText("CPS:" + cps);
        Switch = true;
        Log.d("CPSCheck", "倒计时结束");
    }

}