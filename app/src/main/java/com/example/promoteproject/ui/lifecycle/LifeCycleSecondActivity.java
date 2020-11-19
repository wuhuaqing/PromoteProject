package com.example.promoteproject.ui.lifecycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.promoteproject.MainActivity;
import com.example.promoteproject.R;
import com.example.promoteproject.ui.login.LoginActivity;

public class LifeCycleSecondActivity extends AppCompatActivity {

    private static final String Tag = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(Tag," LifeCycleSecondActivity onCreate !!!");
        setContentView(R.layout.activity_life_cycle_second);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(Tag,"LifeCycleSecondActivity onStart !!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Tag,"LifeCycleSecondActivity onResume !!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Tag,"LifeCycleSecondActivity onPause !!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(Tag,"LifeCycleSecondActivity onStop !!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(Tag,"LifeCycleSecondActivity onRestart !!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Tag,"LifeCycleSecondActivity onDestroy !!!");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(Tag,"LifeCycleSecondActivity onSaveInstanceState !!!");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(Tag,"LifeCycleSecondActivity onRestoreInstanceState !!!");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(Tag,"LifeCycleSecondActivity onConfigurationChanged !!!");
    }
}