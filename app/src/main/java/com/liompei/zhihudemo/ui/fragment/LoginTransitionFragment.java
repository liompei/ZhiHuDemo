package com.liompei.zhihudemo.ui.fragment;

import android.support.v4.app.FragmentTransaction;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseFragment;


/**
 * 登录过渡
 * Created by Liompei
 * on 2016/10/10.
 */

public class LoginTransitionFragment extends BaseFragment implements View.OnClickListener {

    private EditText m_email;  //邮箱
    private LinearLayout no_Register;  //该用户没有注册
    private RelativeLayout to_continue;  //继续
    private LoginFragment mLoginFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_login_transition;
    }

    @Override
    protected void initView() {
        to_continue = (RelativeLayout) findViewById(R.id.to_continue);
        m_email = (EditText) findViewById(R.id.m_email);
        no_Register = (LinearLayout) findViewById(R.id.no_Register);

    }

    @Override
    protected void initEvent() {
        no_Register.setVisibility(View.GONE);
        to_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_continue:

                if (!validate()) {
                    break;
                }

                toStartFragment();

                break;
        }
    }


    //验证
    public boolean validate() {
        boolean valid = true;
        String email = m_email.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            m_email.setError("这不是一个Email地址");
            valid = false;
        } else {
            m_email.setError(null);
        }

        return valid;
    }

    //跳转至下一个fragment
    private void toStartFragment() {


        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_right_in, R.anim.anim_left_out, R.anim.anim_left_in, R.anim.anim_right_out);
        if (mLoginFragment == null) {
            mLoginFragment = new LoginFragment();
        }
        mLoginFragment.setEmail(m_email.getText().toString());
        transaction.addToBackStack("");
        transaction.replace(R.id.frame_container, mLoginFragment);
        transaction.commit();
    }


}
