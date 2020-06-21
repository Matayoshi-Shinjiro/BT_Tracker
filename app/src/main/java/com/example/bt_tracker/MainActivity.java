package com.example.bt_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{   //class 4 and 5

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //setting the attribute here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        TextView mainButton1 = findViewById(R.id.mainButton1); // class 2
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.mainButton2);
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.mainButton3);
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.mainButton4);
        mainButton4.setOnClickListener(this);

        Button setReminderButton = findViewById(R.id.setReminderButton);
        setReminderButton.setOnClickListener(this);
    }

    @Override  // onClick stuff moved to here
    public void onClick(View view){ //  //setting the attribute here class 3
        switch (view.getId()){
            case R.id.mainButton1:
                // mainButton1 push push, do something something
                Intent toLog = new Intent(this, LogActivity.class);
                startActivity(toLog);
                break;

            case R.id.mainButton2:
                // mainButton2 push push, do something something
                Intent toNormal = new Intent(this, NormalActivity.class);
                startActivity(toNormal);
                break;

            case R.id.mainButton3:
                // mainButton3 push push, do something something
                Intent toMechanism = new Intent(this, MechanismActivity.class);
                startActivity(toMechanism);
                break;

            case R.id.mainButton4:
                // mainButton4 push push, do something something
                Intent toHandle = new Intent(this, HandleActivity.class);
                startActivity(toHandle);
                break;

            case R.id.setReminderButton: // class 5
                // setReminderButton push push, do something something
                Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ReminderBroadcastReceiver.class);
                PendingIntent pd = PendingIntent.getBroadcast(this, 0, intent, 0);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                long interval = 1000 * 2;
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(), interval, pd);
                break;
        }
    }

    private void createNotificationChannel(){ // the notification stuff here class 5
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelID = "BT_Tracker_Channel";
            String channelName = "BTTrackerReminderChannel";
            String channelDescription = "Channel for BT Tracker reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channelID, channelName, importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
