package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn3;
    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mBtn3 = findViewById(R.id.btn_3);
        mTv1 = findViewById(R.id.tv_1);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"btn3我被点击了",Toast.LENGTH_SHORT).show();//一定要调用show method

            }
        });
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this,"textview1我被点击了",Toast.LENGTH_SHORT).show();//一定要调用show method

            }
        });

    }
    public void showToast(View view){
        Toast.makeText(this,"btn4我被点击了",Toast.LENGTH_SHORT).show();//一定要调用show method

    }
}
