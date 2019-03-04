package com.ch.example_221_call;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button call_btn;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    //内部类
    private void init() {
        call_btn  = findViewById(R.id.call_btn);
        edit      = findViewById(R.id.edit);
        call_btn.setOnClickListener(new View.OnClickListener() {
            //点击事件
            @Override
            public void onClick(View v) {
                //创建意图
                Intent intent = new Intent();
                //调用系统的界面程序
                intent.setAction(Intent.ACTION_VIEW);
                //调用系统拨号程序
                intent.setAction(Intent.ACTION_DIAL);
                //根据数据类型打开相应的Activity（拨号程序）
                intent.setData(Uri.parse("tel:"+edit.getText().toString()));
                //跳转
                startActivity(intent);
            }
        });
    }


}
