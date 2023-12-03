package com.example.myvietnampost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OrderDomesticallyctivity extends Fragment{
    ImageView imageView1;
    LinearLayout layout1;
    private int clickCount1 = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_order_domesticallyctivity ,container, false);

    }

//    private void initUi() {
//        imageView1 = findViewById(R.id.TTNN_NG);
//        layout1 = findViewById(R.id.id01);
//    }
//    private void initListener() {
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clickCount1++;
//                // Thay đổi hình ảnh dựa trên giá trị của clickCount
//                if (clickCount1 % 2 == 1) {
//                    // Hiển thị hình ảnh 1 khi clickCount là số lẻ
//                    imageView1.setImageResource(R.drawable.angle_down);
//                    layout1.setVisibility(View.GONE);
//
//                } else {
//                    // Hiển thị hình ảnh 2 khi clickCount là số chẵn
//                    imageView1.setImageResource(R.drawable.baseline_expand_less_24);
//
//                    layout1.setVisibility(View.VISIBLE);
//
//                }
//            }
//        });
//    }
}