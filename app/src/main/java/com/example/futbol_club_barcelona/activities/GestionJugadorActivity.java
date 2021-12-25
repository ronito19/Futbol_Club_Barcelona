package com.example.futbol_club_barcelona.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.futbol_club_barcelona.R;

public class GestionJugadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_jugador);
    }

    public void nuevo_jugador(View view) {
        Intent intent = new Intent(this, NuevoJugadorActivity.class);
        startActivity(intent);
    }



    public void actualizar_jugador(View view) {
        Intent intent = new Intent(this, MostrarJugadorActivity.class);
        startActivity(intent);
    }



    public void borrar_jugador(View view) {
        Intent intent = new Intent(this, BorrarJugadorActivity.class);
        startActivity(intent);
    }



    public void mostrar_jugadores(View view) {
        Intent intent = new Intent(this, ActualizarJugadorActivity1.class);
        startActivity(intent);
    }
}