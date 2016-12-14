package com.woodslake.matrix.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.woodslake.matrix.R;
import com.woodslake.matrix.support.base.BaseActivity;
import com.woodslake.matrix.support.util.DeviceInfoUtil;
import com.woodslake.matrix.support.util.LogUtil;

public class MainActivity extends BaseActivity {
    private RecyclerView rv_list;

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
        rv_list = (RecyclerView) findViewById(R.id.rv_list);
    }
}
