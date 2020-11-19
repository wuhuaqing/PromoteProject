package com.example.promoteproject.ui.notify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.promoteproject.R;
import com.example.promoteproject.util.NotifyUtil;

public class NotifyTestActivity extends AppCompatActivity {

    public static final String Channel_notiIn = "pushSensorMsgIn";
    public static final String Channel_notiOut = "pushSensorMsgOut";
    public static final String Channel_paySuce = "pushPaySuce";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_test);
        Button btnSendIn = findViewById(R.id.btnSendIn);
        Button btnSendOut = findViewById(R.id.btnSendOut);
        Button btnSendComon = findViewById(R.id.btnSendComon);


        // createNotifyChannel();

        btnSendIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sendIn(true);
                sendInnotify();
            }
        });

        btnSendOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sendIn(false);
                sendOutnotify();
            }
        });

        btnSendComon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPay();
            }
        });
    }

    public void sendInnotify() {
        StringBuilder soundUri = new StringBuilder("");
        soundUri.append("android.resource://")
                .append(getPackageName())
                .append("/");
        Uri sound = Uri.parse(soundUri.toString() + R.raw.cararrive);
        String title = "车辆驶入";
        String content = "车辆驶入了";

        NotifyUtil notifyUtil = new NotifyUtil(this.getBaseContext(), sound, Channel_notiIn, "地磁驶入信息", NotificationManager.IMPORTANCE_HIGH);
        notifyUtil.sendNotify(1, title, content, R.drawable.ic_notify);
    }


    public void sendOutnotify() {
        StringBuilder soundUri = new StringBuilder("");
        soundUri.append("android.resource://")
                .append(getPackageName())
                .append("/");
        Uri sound = Uri.parse(soundUri.toString() + R.raw.carleave);
        String title = "车辆驶离";
        String content = "车辆驶离了";

        NotifyUtil notifyUtil = new NotifyUtil(this.getBaseContext(), sound, Channel_notiOut, "地磁驶离信息", NotificationManager.IMPORTANCE_HIGH);
        notifyUtil.sendNotify(2, title, content, R.drawable.ic_notify);
    }

    public void sendIn(boolean isIn) {
        Uri sound = null;
        String title = "";
        String content = "";
        String channelId = "";
        int notifyId = 0;
        if (isIn) {
            channelId = Channel_notiIn;
            notifyId = 1;
            title = "车辆驶入";
            content = "车辆驶入了";
        } else {
            channelId = Channel_notiOut;
            notifyId = 2;
            title = "车辆驶离";
            content = "车辆驶离了";
        }
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel(channelId);
            Log.e(this.getClass().getSimpleName(), channel.getImportance() + "");
            if (channel.getImportance() != NotificationManager.IMPORTANCE_HIGH) {
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID, channel.getId());
                startActivity(intent);
                Toast.makeText(this, "请手动将通知打开", Toast.LENGTH_SHORT).show();
            }
        }

        Notification notification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText(content)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_notify)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_notify))
                .setAutoCancel(true)
                .setSound(sound)
                .build();
        manager.notify(notifyId, notification);
    }


    public void sendPay() {

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, Channel_paySuce)
                .setContentTitle("支付成功")
                .setContentText("支付成功了！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_notify)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_notify))
                .setAutoCancel(true)
                .build();
        manager.notify(3, notification);
    }

    public void createNotifyChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = Channel_notiIn;
            String channelName = "地磁驶入信息";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);

            channelId = Channel_notiOut;
            channelName = "地磁驶离信息";
            importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);

            channelId = Channel_paySuce;
            channelName = "支付信息";
            importance = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importance);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importance) {

        StringBuilder soundUri = new StringBuilder("");
        soundUri.append("android.resource://")
                .append(getPackageName())
                .append("/");
        Uri sound = null;
        if (Channel_notiIn.equals(channelId)) {
            sound = Uri.parse(soundUri.toString() + R.raw.cararrive);
        } else if (Channel_notiOut.equals(channelId)) {
            sound = Uri.parse(soundUri.toString() + R.raw.carleave);
        } else if (Channel_paySuce.equals(channelId)) {
            sound = Uri.parse(soundUri.toString() + R.raw.paysuccess);
        }


        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setSound(sound, Notification.AUDIO_ATTRIBUTES_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        /// notificationManager.deleteNotificationChannelGroup(channel.getGroup());
        notificationManager.createNotificationChannel(channel);
    }
}