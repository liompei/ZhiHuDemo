package com.liompei.zhihudemo.ui.fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseFragment;

/**
 * 登录过渡
 * Created by Liompei
 * on 2016/10/10.
 */

public class LoginTransitionFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout to_continue;
    private LoginFragment mLoginFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_login_transition;
    }

    @Override
    protected void initView() {
        to_continue = (RelativeLayout) findViewById(R.id.to_continue);
        to_continue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_continue:
                FragmentTransaction transaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                if (mLoginFragment == null) {
                    mLoginFragment = new LoginFragment();
                }
                transaction2.addToBackStack("");
                transaction2.replace(R.id.frame_container, mLoginFragment);
                transaction2.commit();

                break;
        }
    }
}
