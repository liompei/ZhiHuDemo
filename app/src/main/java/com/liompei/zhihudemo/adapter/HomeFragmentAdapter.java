package com.liompei.zhihudemo.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.callback.LoadFinishCallBack;
import com.liompei.zhihudemo.callback.LoadResultCallBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

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
        holder.ll_card.clearAnimation();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        Map<String,String> map=mList.get(position);
        holder.say_name.setText(map.get("say_name"));
        holder.say_time.setText(map.get("say_time"));
        setAnimation(holder.ll_card,position);
    }

    public void loadFirst(){
        page=1;
        loadData();
    }
    public void loadNext(){
        page++;
        loadData();
    }


    private void loadData(){

        if (page==1){
            mList.clear();
        }
        getData();
        notifyDataSetChanged();
        mLoadResultCallBack.onSuccess(LoadResultCallBack.SUCCESS_OK,null);
        mLoadFinishCallBack.loadFinish(null);

    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private CardView ll_card;  //主布局
        private CircleImageView say_head;  //头像
        private TextView say_name, say_time, say_content;  //姓名,时间,内容
        private ImageView say_img;  //图片
        private ImageButton to_good, to_comment, to_share;  //选单

        public MyHolder(View itemView) {
            super(itemView);
            ll_card= (CardView) itemView.findViewById(R.id.ll_card);
            say_head = (CircleImageView) itemView.findViewById(R.id.say_head);
            say_name = (TextView) itemView.findViewById(R.id.say_name);
            say_time = (TextView) itemView.findViewById(R.id.say_time);
            say_content = (TextView) itemView.findViewById(R.id.say_content);
            say_img = (ImageView) itemView.findViewById(R.id.say_img);
            to_good = (ImageButton) itemView.findViewById(R.id.to_good);
            to_comment = (ImageButton) itemView.findViewById(R.id.to_comment);
            to_share = (ImageButton) itemView.findViewById(R.id.to_share);
        }
    }




    private void getData(){
        for (int i = 0; i < 20; i++) {
            Map<String,String> map=new HashMap<>();
            map.put("say_name","小资");
            map.put("say_time","25分钟");
            mList.add(map);
        }
    }

}
