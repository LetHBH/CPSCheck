package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.text1);


        Button botton1 = findViewById(R.id.button1);
        botton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "跳过去了", Toast.LENGTH_SHORT).show();
                Log.println(Log.INFO, "LLL", "按钮1被点击");
            }
        });
        Button botton2 = findViewById(R.id.button2);
        botton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2.class);
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, MainActivity.class);
                Log.println(Log.INFO, "LLL", "按钮2被点击");
                final Handler handler = new Handler();
                final int delay = 50; // 延迟执行的时间，单位为毫秒
                final int maxCount = 1000;
                final Runnable runnable = new Runnable() {
                    int count = 0;

                    @Override
                    public void run() {
                        if (count < maxCount) {
                            startActivity(intent);
                            startActivity(intent2);
                            count++;
                            LinearLayout linearLayout = findViewById(R.id.linearlayout);
                            Snackbar snackbar = Snackbar.make(linearLayout, "循环" + count + "次", Snackbar.LENGTH_SHORT);
                            snackbar.show();

                            handler.postDelayed(this, delay); // 延迟执行下一次循环
                        }
                    }
                };

                handler.postDelayed(runnable, delay); // 第一次延迟执行
            }
        });

    }
}