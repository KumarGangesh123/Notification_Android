package com.india.notification_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final static String CHANNEL_ID = "messageChannel1"; // channelID to distinguish between the notification
    private final static int NOTIFICATION_ID = 100; // helps to update the message if the ID are matches

    private final static String CHANNEL_ID1 = "messageChannel2"; // channelID to distinguish between the notification
    private final static int NOTIFICATION_ID1 = 200; // helps to update the message if the ID are matches

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this 3 lines are use to convert the .png (images) to Bitmap to set as Icon on notification.

        // Note : always use .png format image for the notification

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.download,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager notification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification nm,nm1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            nm = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("New Message from Gangesh Kumar 1") // Upper Text Message
                    .setSubText("New Message") // Lower Text Message
                    .setContentTitle("Custom Message 1")
                    .setChannelId(CHANNEL_ID)
                    .build();

            nm1 = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentTitle("Custom Message 2")
                    .setChannelId(CHANNEL_ID1)
                    .setContentText("New Message from Gangesh Kumar 2")
                    .setSubText("New Message 2")
                    .build();

            notification.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
            notification.createNotificationChannel(new NotificationChannel(CHANNEL_ID1,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }else{
            nm = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("New Message")
                    .setSubText("New Message from Gangesh Kumar")
                    .build();

            nm1 = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("New Message 2")
                    .setSubText("New Message from Gangesh Kumar 2")
                    .build();
        }

        notification.notify(NOTIFICATION_ID,nm);
        notification.notify(NOTIFICATION_ID1,nm1);


    }
}