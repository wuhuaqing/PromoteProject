package com.example.promoteproject.ui.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.promoteproject.R;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String Tag = "lifecycle";
    private static final String edit = "edit";

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(Tag,"onCreate !!!");
        setContentView(R.layout.activity_life_cycle);
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifeCycleActivity.this, LifeCycleSecondActivity.class));
            }
        });
        editText = findViewById(R.id.edit);
        if(savedInstanceState!=null){
            String text = savedInstanceState.getString(edit);
            editText.setText(text);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(Tag,"onStart !!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Tag,"onResume !!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Tag,"onPause !!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(Tag,"onStop !!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(Tag,"onRestart !!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Tag,"onDestroy !!!");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(Tag,"onSaveInstanceState !!!");
        outState.putString(edit,"123456");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(Tag,"onRestoreInstanceState !!!");
        String text = editText.getText().toString();
        Log.e(Tag,"text: " +  text);
       savedInstanceState.putString(edit,text);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(Tag,"onConfigurationChanged !!!");
    }
}