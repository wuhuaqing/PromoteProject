package com.example.promoteproject.ui.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.promoteproject.R;

/**
 *PopupWindow 随屏幕旋转而旋转的实现方式：
 *  一。清单文件中activity 进行  android:configChanges="orientation|screenSize" 配置
 *
 */
public class PopUpWindowActivity extends AppCompatActivity {
    private static final String Tag = "configChanges";
    PopupWindow  mPopupWindow;
    private Button btnPopup;
    private int orientation;
    private AlertDialog layoutDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);
        btnPopup = findViewById(R.id.btn_popup);
        createPopUp();

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mPopupWindow.showAsDropDown(btnPopup, 0, 0);
                createDialog();
            }
        });


        getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

            }
        });
    }



    private void createPopUp() {
        View contentView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popup_content_layout, null);
        mPopupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
    }


    private  void createDialog(){
        //加载布局并初始化组件
        View dialogView = LayoutInflater.from(this).inflate(R.layout.popup_content_layout, null);
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setView(dialogView);
        layoutDialog = dialogBuilder.create();
        layoutDialog.setCanceledOnTouchOutside(false);
        layoutDialog.show();
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(Tag,"onConfigurationChanged !!!");
        orientation = newConfig.orientation;
        //updatePopUp();
    }

    @Override
    protected void onStop() {
        if(layoutDialog!=null){
            layoutDialog.dismiss();
        }
        super.onStop();
    }

    private void updatePopUp() {
        if(orientation == ActivityInfo.SCREEN_ORIENTATION_USER || orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            mPopupWindow.update(0, 0, -1, -1);
        }else if (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            mPopupWindow.update(0, 800, -1, -1);
        }
    }


}