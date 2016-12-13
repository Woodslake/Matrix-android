package com.woodslake.matrix.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.woodslake.matrix.R;
import com.woodslake.matrix.base.ui.BaseActivity;
import com.woodslake.matrix.engine.LaunchEngine;
import com.woodslake.matrix.util.LogUtil;

/**
 * Created by Woodslake on 2016/12/13.
 */

public class LaunchActivity extends BaseActivity {
    private ImageView iv_launch;
    private LaunchEngine mLaunchEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initVariables(savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
        LogUtil.i(TAG, "initVariables");
        mLaunchEngine = LaunchEngine.createInstance();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        iv_launch = (ImageView) findViewById(R.id.iv_launch);
        String url = mLaunchEngine.getLaunchImg();
        Glide.with(this)
                .load(url)
                .crossFade()
                .into(iv_launch);
    }
}
