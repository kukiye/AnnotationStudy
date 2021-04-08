package com.kuki.annotationstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kuki.annotationstudy.R;
import com.kuki.annotationstudy.inject.InjectUtils;
import com.kuki.annotationstudy.inject.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tv)
    TextView textView;

    @InjectView(R.id.btn)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InjectUtils.injectView(this);

        textView.setText("哈哈哈哈哈哈哈哈哈哈");

        button.setText("跳转界面");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "Lance")
                        .putExtra("isBoy", true);
                startActivity(intent);

            }
        });


    }
}