package com.example.promoteproject.ui.anrtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.promoteproject.R;

public class ANRTestActivity extends AppCompatActivity {

    Object lock = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr_test);
        makeAnr();
       // makeAnr2();
    }

    private void makeAnr() {
        //主线程阻塞制造ANR
         synchronized (lock) {
            try {

                Log.e("anrtest", "线程："+ Thread.currentThread().getName() );
                lock.wait();
                Log.e("anrtest", "主线程开始工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Thread workThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    Log.e("anrtest", "线程："+ Thread.currentThread().getName() );
                    lock.notify();
                    Log.e("anrtest", "子线程开始工作");
                }
            }
        });
        workThread.start();



    }
    private void makeAnr2() {
          Log.e("anrtest", "线程："+ Thread.currentThread().getName() );
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}