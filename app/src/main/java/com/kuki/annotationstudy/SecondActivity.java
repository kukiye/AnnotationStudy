package com.kuki.annotationstudy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kuki.annotationstudy.inject.InjectUtils;
import com.kuki.annotationstudy.inject.InjectView;
import com.kuki.annotationstudy.inject.IntentData;

public class SecondActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView textView;

    @InjectView(R.id.btn)
    Button button;

    @IntentData("name")
    String name;

    @IntentData
    boolean isBoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InjectUtils.injectView(this);

        textView.setText("SecondActivity");

        //        button.setVisibility(View.INVISIBLE);

        InjectUtils.injectIntentData(this);

        button.setText("name=" + name + "，isBoy=" + isBoy);

        Log.d("SecondActivity", "name==" + name + "，isBoy==" + isBoy);


    }
}