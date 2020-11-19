package com.example.promoteproject.util;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.promoteproject.R;

/**
 * description ： TODO:类的作用
 * author : 姓名
 * date : 2020/11/3 16:23
 */
public class NotifyUtil {

    private Context context;
    private String channelId;

    public NotifyUtil(Context context, Uri soundUri, String channelId, String channelName, int importance) {
        this.context = context;
        this.channelId = channelId;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //android 8.0以上需要特殊处理，也就是targetSDKVersion为26以上
            createNotificationChannel(soundUri, channelId, channelName, importance);
        }
    }


    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel(Uri soundUri, String channelId, String channelName, int importance) {

        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setSound(soundUri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                context.NOTIFICATION_SERVICE);
        /// notificationManager.deleteNotificationChannelGroup(channel.getGroup());
        notificationManager.createNotificationChannel(channel);
    }

    public void sendNotify(int notifyId, String title, String content, int drawableRes) {

        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context, channelId)
                .setContentTitle(title)
                .setContentText(content)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(drawableRes)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), drawableRes))
                .setAutoCancel(true)
                .build();
        manager.notify(notifyId, notification);
    }

    public void sendNotify(int notifyId, PendingIntent intent, String title, String content, int drawableRes) {

        NotificationManager manager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context, channelId)
                .setContentTitle(title)
                .setContentText(content)
                .setContentIntent(intent)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(drawableRes)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), drawableRes))
                .setAutoCancel(true)
                .build();
        manager.notify(notifyId, notification);
    }
}
