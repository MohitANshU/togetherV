package com.adcoretechnologies.togetherv.auth.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.adcoretechnologies.togetherv.R;
import com.adcoretechnologies.togetherv.core.components.ComponentItemSelector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.tvCity)
    TextView tvCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvCity)
    public void onCitySelect() {
        ComponentItemSelector selector=new ComponentItemSelector();
        String[] items=new String[]{"Noida","Delhi"};
        selector.initialize(items,"Select City");
    }

}
