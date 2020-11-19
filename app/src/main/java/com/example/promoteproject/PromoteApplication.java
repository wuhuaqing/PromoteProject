package com.example.promoteproject;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.promoteproject.net.NetMoudle;

public class PromoteApplication extends Application {

    public static  Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext= this;
//        NetMoudle.buildRetrofit();
        registerAcLife();

    }

    public void registerAcLife(){
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            private int createdCounter = 0;
            private int startedCounter = 0;

            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                createdCounter ++;
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
               startedCounter++;
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                  startedCounter--;
                  if (startedCounter == 0 && !activity.isChangingConfigurations() && !activity.isFinishing()){
                      Log.e("lifecycle: " ,"Home") ;
                  }
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                createdCounter--;
                if (createdCounter == 0 && !activity.isChangingConfigurations() ){
                    Log.e("lifecycle: " ,"exit") ;
                }
            }
        });
    }
}
