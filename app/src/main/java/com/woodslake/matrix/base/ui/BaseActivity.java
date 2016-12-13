package com.woodslake.matrix.base.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.woodslake.matrix.util.LogUtil;

/**
 * Created by Woodslake on 2016/12/13.
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.i(TAG, "onCreate");
        initVariables(savedInstanceState);
        initView(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i(TAG, "onDestroy");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtil.i(TAG, "onLowMemory");
    }

    protected abstract void initVariables(Bundle savedInstanceState);

    protected abstract void initView(Bundle savedInstanceState);

}
