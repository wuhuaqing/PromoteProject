package com.example.promoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Repository;
import com.example.promoteproject.net.NetMoudle;
import com.example.promoteproject.net.RxNetMoudle;
import com.example.promoteproject.ui.anrtest.ANRTestActivity;
import com.example.promoteproject.ui.lifecycle.LifeCycleActivity;
import com.example.promoteproject.ui.login.LoginActivity;
import com.example.promoteproject.ui.login.PopUpWindowActivity;
import com.example.promoteproject.ui.notify.NotifyTestActivity;
import com.example.promoteproject.ui.recyclerview.RecyclerViewActivity;
import com.example.promoteproject.util.DebouncingOnClickListener;

import java.util.List;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFollower = findViewById(R.id.btnFollower);
        textView = findViewById(R.id.tv_resp);
        Button btnNotify = findViewById(R.id.btn_notify);
        Button btnDoubleclick = findViewById(R.id.btn_doubleclick);
        Button btnPopup = findViewById(R.id.btn_popup);


        btnFollower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // netMoudle.getFollowers();
                //retrofitResp();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        findViewById(R.id.btnlifecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
            }
        });
        findViewById(R.id.btnAnr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ANRTestActivity.class));
            }
        });

        btnDoubleclick.setOnClickListener(new DebouncingOnClickListener() {
            @Override
            public void doClick(View v) {
                Log.e(this.getClass().getName(), "打印操作！！！！");
            }
        });

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PopUpWindowActivity.class));
            }
        });
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotifyTestActivity.class));
            }
        });
        findViewById(R.id.btnAnimator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotifyTestActivity.class));
            }
        });
        findViewById(R.id.btnRecycler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });
    }


}