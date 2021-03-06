package com.example.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.demo.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> { // Adapter 类有一个泛型
    // public abstract static class Adapter<VH extends RecyclerView.ViewHolder> {
    //所以我们要实现一个 新的class  LinearViewHolder（）,  泛型也改成我们实现的LinearAdapter.LinearViewHolder
    private Context mcontext;
    private OnItemClickListener mlistener;
    public StaggeredGridAdapter(Context context, OnItemClickListener listener){//实现构造方法， 给context赋值
        this.mcontext = context;
        this.mlistener = listener;
    }
    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //返回一个viewholder， viewholder 被传入一个布局
        return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_staggered_grid_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder viewHolder, final int i) {
        if(i%2!=0)
            viewHolder.imageView.setImageResource(R.drawable.img0);
        else
            viewHolder.imageView.setImageResource(R.drawable.img1);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {//列表的长度
        return 80;
    }


    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public LinearViewHolder(View itemView){//实现构造方法
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
    //为了在 activity中 定义 监听操作，  定义一个借口
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
