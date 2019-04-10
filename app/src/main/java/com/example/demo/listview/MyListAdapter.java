package com.example.demo.listview;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    MyListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;  //实际开发中不是固定的
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 复用性好的写法
    static class  ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvContent,tvTime;
    }


    //上面三个方法不太常用，  getView()非常重要
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView  = convertView.findViewById(R.id.iv);
            holder.tvContent = convertView.findViewById(R.id.tv_content);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("2999.0.3");
        holder.tvContent.setText("这是内容");
        Glide.with(mContext).load("https://tse1.mm.bing.net/th?id=AMMS_a7fc1af540851fa81416f9d842b5847c&w=236&h=183&c=8&rs=1&o=5&pid=3.1&rm=2").into(holder.imageView);
        return convertView;
    }

}
