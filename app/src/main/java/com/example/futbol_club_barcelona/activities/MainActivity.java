package com.example.futbol_club_barcelona.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.futbol_club_barcelona.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gestionar_jugadores(View view) {
        Intent intent = new Intent(this, GestionJugadorActivity.class);
        startActivity(intent);
    }
}