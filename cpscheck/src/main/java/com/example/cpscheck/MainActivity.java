package com.example.cpscheck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent = new Intent();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button solob = findViewById(R.id.buttons);
        Button doubleb = findViewById(R.id.buttond);
        solob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(MainActivity.this, soloActivity.class);
                startActivity(intent);
            }
        });
        doubleb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(MainActivity.this, doubleActivity.class);
                startActivity(intent);
            }
        });
    }
}