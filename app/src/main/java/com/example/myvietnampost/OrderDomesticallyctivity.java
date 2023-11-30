package com.example.myvietnampost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OrderDomesticallyctivity extends AppCompatActivity {
    ImageView imageView1;
    private int clickCount1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_domesticallyctivity);
        initUi();
        initListener();
    }

    private void initUi() {
        imageView1 = findViewById(R.id.TTNN_NG);
    }
    private void initListener() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCount1++;
                // Thay đổi hình ảnh dựa trên giá trị của clickCount
                if (clickCount1 % 2 == 1) {
                    // Hiển thị hình ảnh 1 khi clickCount là số lẻ
                    imageView1.setImageResource(R.drawable.angle_down);
                } else {
                    // Hiển thị hình ảnh 2 khi clickCount là số chẵn
                    imageView1.setImageResource(R.drawable.baseline_expand_less_24);
                }
            }
        });
    }
}