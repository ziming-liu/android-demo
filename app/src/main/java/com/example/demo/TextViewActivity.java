package com.example.demo;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTextView3,mTextView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTextView3 = findViewById(R.id.tv_3);
        mTextView4 = findViewById(R.id.tv_4);
        mTextView4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//会有锯齿
        mTextView4.getPaint().setAntiAlias(true);//remove 锯齿
        //mTextView4.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//   下划线
        mTextView4.setText(Html.fromHtml("<u>runninginging</u>"));//html 方式设置下划线,该方式可以与上面中划线共存
        //set the size of icon
        Drawable icon = getResources().getDrawable(R.drawable.bird);//get icon drawable
        //setBounds(left,top,right,bottom)里的参数从左到右分别是
        //drawable的左边到textview左边缘+padding的距离，drawable的上边离textview上边缘+padding的距离
        //drawable的右边边离textview左边缘+padding的距离，drawable的下边离textview上边缘+padding的距离
        //所以right-left = drawable的宽，top - bottom = drawable的高
        icon.setBounds(0,0,100,100);
        mTextView3.setCompoundDrawables(null, null, icon, null);


    }
}
