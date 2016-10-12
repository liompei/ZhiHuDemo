package com.liompei.zhihudemo.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
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
    private EditText et_email, et_password;

    private MyHandler mMyHandler;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_login;
    }


    @Override
    protected void initView() {
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        to_login = (RelativeLayout) findViewById(R.id.to_login);

    }

    @Override
    protected void initEvent() {
        mMyHandler = new MyHandler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                mMyHandler.sendMessage(message);
            }
        }).start();
        to_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_login:
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
                getActivity().finish();
                break;
        }
    }


    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    et_email.setText(email);
                    break;
            }
        }
    }


}
