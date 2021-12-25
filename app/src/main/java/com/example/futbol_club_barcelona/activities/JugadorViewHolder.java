package com.example.futbol_club_barcelona.activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.clases.Jugador;

import java.util.List;

public class JugadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static final String EXTRA_OBJETO_JUGADOR = "es.ronito19.jugadorViewHolder.objeto_jugador";
    public TextView txt_rv_jugador_nombrej = null;
    public TextView txt_rv_posicion = null;
    public TextView txt_rv_edad = null;
    public TextView txt_rv_sueldo = null;
    public TextView txt_rv_numCam = null;
    ListaJugadoresAdapter lcAdapter;

    public JugadorViewHolder(@NonNull View itemView, ListaJugadoresAdapter lcAdapter) {
        super(itemView);
        txt_rv_jugador_nombrej = (TextView)  itemView.findViewById(R.id.txt_rv_jugador_nombrej);
        txt_rv_posicion = (TextView)  itemView.findViewById(R.id.txt_rv_posicion);
        txt_rv_edad = (TextView)  itemView.findViewById(R.id.txt_rv_edad);
        txt_rv_sueldo = (TextView)  itemView.findViewById(R.id.txt_rv_sueldo);
        txt_rv_numCam = (TextView)  itemView.findViewById(R.id.txt_rv_numCam);
        this.lcAdapter = lcAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int mPosition = getAdapterPosition();
        // int mPosition = getLayoutPosition();
        List<Jugador> jugadores = this.lcAdapter.getListaJugadores();
        Jugador jugador = jugadores.get(mPosition);
        // lcAdapter.notifyDataSetChanged();
        Intent intent = new Intent(lcAdapter.getJ(), MostrarDetallesJugadorActivity.class);
        intent.putExtra(EXTRA_OBJETO_JUGADOR, jugador);
        lcAdapter.getJ().startActivity(intent);
    }
}
