package com.example.mradmin.notesapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mradmin.notesapp.async_task.AsyncTaskListener;

public abstract class BaseActivity extends AppCompatActivity implements AsyncTaskListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void initViews();
}
