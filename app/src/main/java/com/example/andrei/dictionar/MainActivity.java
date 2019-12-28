package com.example.andrei.dictionar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static int TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Notification
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.MINUTE,1);
        calendar.set(Calendar.MINUTE,2);
        calendar.set(Calendar.MINUTE,3);
        calendar.set(Calendar.MINUTE,4);
        calendar.set(Calendar.MINUTE,5);

        Intent intent = new Intent(getApplicationContext(),Notification_reciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);




        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, AlegereaDictionarului.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.animate().rotation(360).setDuration(2000).start();

    }
}
