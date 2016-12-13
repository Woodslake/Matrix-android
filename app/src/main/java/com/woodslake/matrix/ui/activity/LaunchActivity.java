package com.woodslake.matrix.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.woodslake.matrix.R;
import com.woodslake.matrix.base.ui.BaseActivity;
import com.woodslake.matrix.engine.LaunchEngine;

/**
 * Created by Woodslake on 2016/12/13.
 */

public class LaunchActivity extends BaseActivity {
    private ImageView iv_launch;
    private LaunchEngine mLaunchEngine;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_launch);
        initVariables(savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    protected void initVariables(Bundle savedInstanceState) {
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
