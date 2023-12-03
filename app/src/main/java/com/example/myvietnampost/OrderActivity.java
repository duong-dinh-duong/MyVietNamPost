package com.example.myvietnampost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class OrderActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initUi();
        initListener();
    }
    private void initUi() {
        frameLayout = findViewById(R.id.TDHTN);
    }
    private void initListener() {
        
    }


}