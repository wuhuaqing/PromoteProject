package com.example.promoteproject.util;

import android.view.View;

public abstract class DebouncingOnClickListener implements View.OnClickListener {

    private static boolean ennableClick = true;

    private static final Runnable enableAgain = new Runnable() {
        @Override
        public void run() {
            ennableClick = true;
        }
    };

    @Override
    public void onClick(View v) {
        if(ennableClick){
            ennableClick =false;
            //v.post(enableAgain);
            v.postDelayed(enableAgain,1000);
            doClick(v);

        }
    }

    public abstract  void doClick(View v);


}
