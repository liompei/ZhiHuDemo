package com.liompei.zhihudemo.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.adapter.HomeFragmentAdapter;
import com.liompei.zhihudemo.base.BaseFragment;
import com.liompei.zhihudemo.callback.LoadMoreListener;
import com.liompei.zhihudemo.callback.LoadResultCallBack;
import com.liompei.zhihudemo.view.AutoRecyclerView;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by Liompei
 * on 2016/9/29.
 */

public class HomeFragment extends BaseFragment implements LoadResultCallBack, SwipeRefreshLayout.OnRefreshListener {

    private AVLoadingIndicatorView av_loading;
    private AutoRecyclerView mRecyclerView;
    private RecyclerViewHeader mRecyclerViewHeader;
    private HomeFragmentAdapter adapter;
    private SwipeRefreshLayout swipe;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        av_loading = (AVLoadingIndicatorView) findViewById(R.id.av_loading);
        mRecyclerViewHeader = (RecyclerViewHeader) findViewById(R.id.header);
        mRecyclerView = (AutoRecyclerView) findViewById(R.id.recycler);
        swipe= (SwipeRefreshLayout) findViewById(R.id.swipe);

    }

    @Override
    protected void initEvent() {
        swipe.setColorSchemeResources(android.R.color.holo_blue_light,android.R.color.holo_orange_light,android.R.color.holo_green_light,android.R.color.holo_red_light);
        swipe.setOnRefreshListener(this);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void loadMore() {
                //adapter加载更多
                adapter.loadNext();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //需要加载图片
        mRecyclerView.setOnPauseListenerParams(false,true);
        mRecyclerViewHeader.attachTo(mRecyclerView);
        adapter = new HomeFragmentAdapter(getActivity(),mRecyclerView,this);
        mRecyclerView.setAdapter(adapter);
        adapter.loadFirst();
        av_loading.show();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //回调
    @Override
    public void onSuccess(int result, Object object) {
        Toast.makeText(getActivity(), "加载完成", Toast.LENGTH_SHORT).show();
        av_loading.hide();
        if (swipe.isRefreshing()){
            swipe.setRefreshing(false);
        }
    }

    @Override
    public void onError(int code, String msg) {
        Toast.makeText(getActivity(), "加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        adapter.loadFirst();
    }
}
