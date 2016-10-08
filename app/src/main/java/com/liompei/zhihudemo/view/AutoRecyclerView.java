package com.liompei.zhihudemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.liompei.zhihudemo.App;
import com.liompei.zhihudemo.callback.LoadFinishCallBack;
import com.liompei.zhihudemo.callback.LoadMoreListener;

/**
 * Created by Liompei
 * on 2016/10/8.
 */

public class AutoRecyclerView extends RecyclerView implements LoadFinishCallBack {

    private boolean isLoadingMore;
    private LoadMoreListener mLoadMoreListener;


    public AutoRecyclerView(Context context) {
        super(context, null);
    }

    public AutoRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public AutoRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        isLoadingMore = false;
        addOnScrollListener(new AutoLoadScrollListener(null, true, true));

    }

    //如果需要显示图片，需要设置这几个参数，快速滑动时，暂停图片加载
    public void setOnPauseListenerParams(boolean pauseOnScroll, boolean pauseOnFling) {
        addOnScrollListener(new AutoLoadScrollListener(Glide.get(App.getInstance()), pauseOnScroll, pauseOnFling));
    }

    //用于开始监听设置加载更多的操作
    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
    }

    //加载完成回调方法
    @Override
    public void loadFinish(Object obj) {
        isLoadingMore = false;
    }


    /**
     * 滑动监听
     */
    private class AutoLoadScrollListener extends OnScrollListener {
        private Glide mGlide;
        private final boolean pauseOnScroll;  //停止滚动
        private final boolean pauseOnFling;  //停止滑动

        public AutoLoadScrollListener(Glide glide, boolean pauseOnScroll, boolean pauseOnFling) {
            this.mGlide = glide;
            this.pauseOnScroll = pauseOnScroll;
            this.pauseOnFling = pauseOnFling;

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //由于GridLayoutManager是LinearLayoutManager子类，所以也适用
            if (getLayoutManager() instanceof LinearLayoutManager) {
                int lastVisibleItem = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = getAdapter().getItemCount();

                //实例化回调接口,不是加载状态,并且剩下2个item,并且向下滑动,则自动加载
                if (mLoadMoreListener != null && !isLoadingMore && lastVisibleItem >= totalItemCount - 2 && dy > 0) {
                    mLoadMoreListener.loadMore();
                    isLoadingMore = true;
                }
            }

        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (mGlide != null) {
                switch (newState) {
                    //视图已经停止滑动
                    case SCROLL_STATE_IDLE:
                        Glide.with(App.getInstance()).pauseRequests();
                        break;
                    //拖动状态(手指在上面)
                    case SCROLL_STATE_DRAGGING:
                        if (pauseOnScroll) {
                            Glide.with(App.getInstance()).pauseRequests();
                        } else {
                            Glide.with(App.getInstance()).resumeRequests();
                        }
                        break;
                    //滑动状态
                    case SCROLL_STATE_SETTLING:
                        if (pauseOnFling) {
                            Glide.with(App.getInstance()).pauseRequests();
                        } else {
                            Glide.with(App.getInstance()).resumeRequests();
                        }
                        break;
                }
            }
        }
    }


}
