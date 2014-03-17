package com.maxvandervelde.android.standard.activity;

import android.os.Bundle;
import com.maxvandervelde.standard.R;

public class MainActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
