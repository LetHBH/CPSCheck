package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face1);
        Button botton3 = findViewById(R.id.button1);
        botton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Main2.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Main2.this, "跳回去了", Toast.LENGTH_SHORT).show();
                Log.println(Log.INFO, "LLL", "face按钮1被点击");
            }
        });
    }
}
