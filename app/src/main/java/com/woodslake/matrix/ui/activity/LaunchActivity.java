package com.woodslake.matrix.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.woodslake.matrix.R;
import com.woodslake.matrix.support.base.BaseActivity;
import com.woodslake.matrix.engine.LaunchEngine;
import com.woodslake.matrix.support.util.LogUtil;

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
        mLaunchEngine = LaunchEngine.createInstance();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        iv_launch = (ImageView) findViewById(R.id.iv_launch);
        String url = mLaunchEngine.getLaunchImg();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.launch);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Glide.with(this)
                .load(url)
                .animate(animation)
                .into(iv_launch);
    }
}
