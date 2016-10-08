package com.liompei.zhihudemo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.callback.LoadFinishCallBack;
import com.liompei.zhihudemo.callback.LoadResultCallBack;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Liompei
 * on 2016/10/8.
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.MyHolder> {

    private int page;
    private int lastPosition = -1;
    private Activity mActivity;
    private ArrayList<Map<String, String>> mList;

    private LoadFinishCallBack mLoadFinishCallBack;
    private LoadResultCallBack mLoadResultCallBack;


    public HomeFragmentAdapter(Activity activity, LoadFinishCallBack loadFinishCallBack, LoadResultCallBack loadResultCallBack) {
        mActivity = activity;
        mLoadFinishCallBack = loadFinishCallBack;
        mLoadResultCallBack = loadResultCallBack;
        mList = new ArrayList<>();
    }

    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.item_bottom_in);
            view.setAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(MyHolder holder) {
        super.onViewDetachedFromWindow(holder);
        //布局清除动画
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }

}
