package com.example.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> { // 因为实现了多个不同的LinearViewHoler(),
    //所以， 泛型都是  RecyclerView.ViewHolder ， 而不是 一开始Recyclerview列表视图中直接用LinearViewHolder
    private Context mcontext;
    private OnItemClickListener mlistener;
    public  LinearAdapter(Context context,OnItemClickListener listener){//实现构造方法， 给context赋值
        this.mcontext = context;
        this.mlistener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {//按照规则，即viewType，返回不同的viewholder
        if(viewType==0)
            //返回一个viewholder， viewholder 被传入一个布局
            return new LinearViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item,viewGroup,false));
        else
            return new LinearViewHolder2(LayoutInflater.from(mcontext).inflate(R.layout.layout_linear_item2,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {//对不同的viewholder有不同的执行
        if(getItemViewType(i)==0) {
            ((LinearViewHolder) viewHolder).textView.setText("hello world!");
        }
        else{
            ((LinearViewHolder2)viewHolder).textView.setText("狮子王");
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(i);
            }
        });
    }

    @Override
    public int getItemViewType(int position){//定义规则，什么情况用哪种viewholder
        if(position %2==0)
            return 0;
        else
            return 1;
    }

    @Override
    public int getItemCount() {//列表的长度
        return 50;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public LinearViewHolder(View itemView){//实现构造方法
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
    //定义一种新的viewholder
    class LinearViewHolder2 extends RecyclerView.ViewHolder{
        private TextView textView;
        private ImageView imageView;
        public LinearViewHolder2(View itemView){//实现构造方法
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }
    //为了在 activity中 定义 监听操作，  定义一个借口
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
