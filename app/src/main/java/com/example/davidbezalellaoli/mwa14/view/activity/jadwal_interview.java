package com.example.davidbezalellaoli.mwa14.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.davidbezalellaoli.mwa14.R;

public class jadwal_interview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_interview);
        this.setTitle("Quantum");
    }
    //kembali ke halaman sebelumnya
    public void onClickBack(View view){
        onBackPressed();
    }
}
