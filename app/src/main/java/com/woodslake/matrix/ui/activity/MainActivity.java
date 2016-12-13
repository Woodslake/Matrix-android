package com.woodslake.matrix.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.woodslake.matrix.R;
import com.woodslake.matrix.base.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables(savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
