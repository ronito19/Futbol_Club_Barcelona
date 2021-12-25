package com.example.futbol_club_barcelona.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.clases.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ListaJugadoresAdapter extends RecyclerView.Adapter<JugadorViewHolder>
{
    private Context j;
    private List<Jugador>  listaJugadores;
    private LayoutInflater mInflater;


    public void setJ(Context j) {
        this.j = j;
        this.listaJugadores = new ArrayList<Jugador>();
    }


    public ListaJugadoresAdapter(Context j, List<Jugador> listaJugadores)
    {
        this.j = j;
        this.listaJugadores = listaJugadores;
        mInflater = LayoutInflater.from(j);
    }


    public Context getJ()
    {
        return j;
    }


    public List<Jugador> getListaJugadores()
    {
        return listaJugadores;
    }


    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
      /*  if(this.listaJugadores == null)
        {
            Log.i("jugadores","la lista jugadores es nulo");
        }
        else{
            for(Jugador j:listaJugadores)
            {
                Log.i("jugadores","jugador -> " + c.getJugador());
            }
        }
        */
        notifyDataSetChanged();
    }


    public ListaJugadoresAdapter(Context j) {
        this.j = j;
        mInflater = LayoutInflater.from(j);
    }



    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_recyclerview_jugador, parent, false);
        return new JugadorViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        if(listaJugadores!=null) {
            Jugador jugador_actual = listaJugadores.get(position);
            holder.txt_rv_jugador_nombrej.setText("Nombre: " + jugador_actual.getNombre());
            holder.txt_rv_posicion.setText(String.valueOf("Posicion: " + jugador_actual.getPosicion()));
            holder.txt_rv_edad.setText(Integer.parseInt("Edad: " + jugador_actual.getEdad()));
            holder.txt_rv_sueldo.setText(String.valueOf("Sueldo: " + jugador_actual.getSueldo()));
            holder.txt_rv_numCam.setText(Integer.parseInt("numCam: " + jugador_actual.getNumeroCam()));

        }

    }


    @Override
    public int getItemCount()
    {
        if (listaJugadores != null)
            return listaJugadores.size();
        else return 0;
    }


}
