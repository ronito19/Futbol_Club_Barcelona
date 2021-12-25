package com.example.futbol_club_barcelona.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.clases.Jugador;

public class MostrarDetallesJugadorActivity extends AppCompatActivity {

    TextView txt_detalle_nombrej = null;
    TextView txt_detalle_posicionj = null;
    TextView txt_detalle_edadj = null;
    TextView txt_detalle_sueldoj = null;
    TextView txt_detalle_numCamj = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_jugador);
        txt_detalle_nombrej = findViewById(R.id.txt_detalle_nombrej);
        txt_detalle_posicionj = findViewById(R.id.txt_detalle_posicionj);
        txt_detalle_edadj = findViewById(R.id.txt_detalle_edadj);
        txt_detalle_sueldoj = findViewById(R.id.txt_detalle_sueldoj);
        txt_detalle_numCamj = findViewById(R.id.txt_detalle_numCamj);
        Intent intent = getIntent();
        if(intent != null)
        {
            Jugador j = (Jugador) intent.getSerializableExtra(JugadorViewHolder.EXTRA_OBJETO_JUGADOR);
            txt_detalle_nombrej.setText(j.getNombre());
            txt_detalle_nombrej.setText("jugadores: " + String.valueOf(j.getNombre()));
            txt_detalle_posicionj.setText("posicion: " + String.valueOf(j.getPosicion()));
            txt_detalle_edadj.setText("edad: " + Integer.valueOf(j.getEdad()));
            txt_detalle_sueldoj.setText("sueldo: " + Double.valueOf(j.getSueldo()));
            txt_detalle_numCamj.setText("numCam: " + Integer.valueOf(j.getNumeroCam()));
        }
    }

}
