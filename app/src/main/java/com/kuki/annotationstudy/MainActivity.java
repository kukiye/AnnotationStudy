package com.kuki.annotationstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kuki.annotationstudy.R;
import com.kuki.annotationstudy.inject.InjectUtils;
import com.kuki.annotationstudy.inject.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InjectUtils.injectView(this);


        textView.setText("哈哈哈哈哈哈哈哈哈哈");

    }
}