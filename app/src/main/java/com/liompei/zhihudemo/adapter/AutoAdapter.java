package com.liompei.zhihudemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liompei.zhihudemo.R;

/**
 * Created by Liompei
 * on 2016/9/30.
 */

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.MyHolder> {



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto,parent,false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.text.setText("test");

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public MyHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }


}
