package com.liompei.zhihudemo.ui.fragment;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseFragment;

/**
 * Created by Liompei
 * on 2016/10/10.
 */

public class RegisterFragment extends BaseFragment implements View.OnClickListener {

    private Toolbar mToolbar;
    private RelativeLayout go_on;  //开始吧
    private EditText a_email, a_password, a_username;
    private RegisterFinishFragment mRegisterFinishFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("注册");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_white_black_24dp);
        a_email = (EditText) findViewById(R.id.a_email);
        a_password = (EditText) findViewById(R.id.a_password);
        a_username = (EditText) findViewById(R.id.a_username);
        go_on = (RelativeLayout) findViewById(R.id.go_on);
        go_on.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_on:
                if (!validate()) {
                    return;
                }
                String mEmail = a_email.getText().toString().trim();
                String mPassword = a_password.getText().toString();
                String mUsername = a_username.getText().toString();
                AVUser user = new AVUser();
                user.setUsername(mUsername);
                user.setPassword(mPassword);
                user.setEmail(mEmail);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                            toStartActivity();
                        } else {
                            Toast.makeText(getActivity(), "注册失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;
        }
    }


    private void toStartActivity() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (mRegisterFinishFragment == null) {
            mRegisterFinishFragment = new RegisterFinishFragment();
        }
        transaction.addToBackStack("");
        transaction.replace(R.id.frame_container, mRegisterFinishFragment);
        transaction.commit();

    }


    //验证
    private boolean validate() {
        boolean valid = true;
        String email = a_email.getText().toString();
        String password = a_password.getText().toString();
        String username = a_username.getText().toString().trim();


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            a_email.setError("这不是一个Email地址");
            valid = false;
        } else {
            a_email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 15) {
            a_password.setError("长度要在4-15之间");
            valid = false;
        } else {
            a_password.setError(null);
        }

        if (username.isEmpty()) {
            a_username.setError("请输入一个有效的用户名");
            valid = false;
        } else {
            a_username.setError(null);
        }


        return valid;
    }


}
