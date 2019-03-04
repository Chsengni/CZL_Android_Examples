package com.ch.a331_example_01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LayoutInflater inflater = MainActivity.this.getLayoutInflater();
            View loginView = inflater.inflate(R.layout.login_view, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setIcon(R.drawable.ic_launcher_background)
                    .setTitle("用户登录")
                    .setView(loginView)
                    .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"点击了 登录 ",Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.create().show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(listener);

    }
}
