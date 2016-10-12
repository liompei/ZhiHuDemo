package com.liompei.zhihudemo.ui.fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseFragment;

/**
 * Created by Liompei
 * on 2016/10/10.
 */

public class FirstFragment extends BaseFragment implements View.OnClickListener {


    private RelativeLayout to_register, to_login;
    private RegisterFragment mRegisterFragment;
    private LoginTransitionFragment mLoginTransitionFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initView() {
        to_register = (RelativeLayout) findViewById(R.id.to_register);
        to_login = (RelativeLayout) findViewById(R.id.to_login);
    }

    @Override
    protected void initEvent() {
        to_register.setOnClickListener(this);
        to_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_register:
                FragmentTransaction transaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                transaction1.setCustomAnimations(R.anim.anim_bottom_in, R.anim.anim_top_out,R.anim.anim_top_in,R.anim.anim_bottom_out);
                if (mRegisterFragment == null) {
                    mRegisterFragment = new RegisterFragment();
                }
                transaction1.addToBackStack("1");
                transaction1.replace(R.id.frame_container, mRegisterFragment);
                transaction1.commit();
                break;
            case R.id.to_login:
                FragmentTransaction transaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                transaction2.setCustomAnimations(R.anim.anim_right_in, R.anim.anim_left_out,R.anim.anim_left_in,R.anim.anim_right_out);
                if (mLoginTransitionFragment == null) {
                    mLoginTransitionFragment = new LoginTransitionFragment();
                }
                transaction2.addToBackStack("2");

                transaction2.replace(R.id.frame_container, mLoginTransitionFragment);
                transaction2.commit();
                break;
        }
    }
}
