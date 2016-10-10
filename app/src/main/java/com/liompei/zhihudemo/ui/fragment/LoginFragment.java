package com.liompei.zhihudemo.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.liompei.zhihudemo.MainActivity;
import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseFragment;

/**
 * Created by Liompei
 * on 2016/10/10.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout to_login;

    @Override
    protected int getLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {

        to_login = (RelativeLayout) findViewById(R.id.to_login);
        to_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_login:
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_right_in,R.anim.anim_left_out);
                break;
        }
    }
}
