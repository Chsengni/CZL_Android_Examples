package com.ch.a341_example_01;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.inflateMenu(R.menu.menu);
            toolbar.setOnMenuItemClickListener(new MyMenuItemClickListener());
        }else {
            Toast.makeText(this,"不行哦",Toast.LENGTH_SHORT).show();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
   private class MyMenuItemClickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.scan :
                    Toast.makeText(MainActivity.this,"你点击了(我的好友)",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.discoverable:
                    Toast.makeText(MainActivity.this,"你点击了(设置在线)",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.back:
                    finish();
                    System.exit(0);
                    break;

            }

            return false;
        }
    }

}
