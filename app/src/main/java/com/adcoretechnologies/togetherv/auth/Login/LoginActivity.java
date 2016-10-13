package com.adcoretechnologies.togetherv.auth.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.widget.TextView;

import com.adcoretechnologies.togetherv.R;
import com.adcoretechnologies.togetherv.auth.register.RegisterActivity;
import com.adcoretechnologies.togetherv.core.base.BaseActivity;
import com.adcoretechnologies.togetherv.util.Const;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.etUserName)
    TextInputEditText etUserName;

    @BindView(R.id.etPassword)
    TextInputEditText etPassword;

    @BindView(R.id.tvVersion)
    TextView tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        init();
    }

    @Override
    public void init() {
        if (Const.IS_TEST) {
            etUserName.setText("test1@gmail.com");
            etPassword.setText("123456");
            log("in test mode");
        }
    }


    @OnClick(R.id.btnLogin)
    public void onLogin() {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            etUserName.setError("Input username");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Input password");
            return;
        }

        performLogin(userName, password);
    }

    private void performLogin(String userName, String password) {
        showProgressDialog("Performing login", "Please wait...");

        // TODO
        hideDialog();
    }

    @OnClick(R.id.tvRegister)
    public void onRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tvReset)
    public void onReset() {
        toast("perform reset");
    }

    @Override
    public void log(String message) {
        super.log(getClass().getSimpleName(), message);
    }
}
