package com.example.davidbezalellaoli.mwa14.view.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.davidbezalellaoli.mwa14.R;

public class loker5 extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 140876;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loker5);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        this.setTitle("Quantum");
    }

    public void onClick(View view){
        //build the notification

        notification.setSmallIcon(R.drawable.ic_notification);
        notification.setTicker("this is ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Quantum - aplikasi cari lowongan kerja");
        notification.setContentText("Jadwal interview");

        Intent intent = new Intent(this, jadwal_interview.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

        Toast.makeText(loker5.this, "Berhasil diapply, silahkan tunggu notifikasi selanjutnya", Toast.LENGTH_LONG).show();
    }
    public void onClickBack(View view){
        onBackPressed();
    }
}
