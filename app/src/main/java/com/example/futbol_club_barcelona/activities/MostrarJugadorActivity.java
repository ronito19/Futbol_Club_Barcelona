package com.example.futbol_club_barcelona.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.viewModel.JugadorViewModel;

import java.util.Collections;
import java.util.List;

public class MostrarJugadorActivity extends AppCompatActivity
{

    private RecyclerView rv_jugadores;
    private ListaJugadoresAdapter mAdapter;
    private List<Jugador> jugadores;
    JugadorViewModel mJugadorViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_jugador);
        rv_jugadores = findViewById(R.id.rv_jugadores);
        //----------------------------------------------------------------------------
        mJugadorViewModel = new ViewModelProvider(this).get(JugadorViewModel.class);
        //-----------------------------------------------------------
        mAdapter = new ListaJugadoresAdapter(this);
        //-----------------------------------------------------------
        mJugadorViewModel = new ViewModelProvider(this).get(JugadorViewModel.class);
        LiveData<List<Jugador>> cursosLive = mJugadorViewModel.obtenerjugadores();
        if(cursosLive != null)
        {
            cursosLive.observe(this, new Observer<List<Jugador>>()
            {
                @Override
                public void onChanged(@Nullable final List<Jugador> jugadors)
                {
                    // Update the cached copy of the words in the adapter.
                    jugadores = jugadors;
                    mAdapter.setListaJugadores(jugadors);
                }
            });
        }
        //------------------------------------------------------------
        rv_jugadores.setAdapter(mAdapter);
        rv_jugadores.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target)
            {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(jugadores, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction)
            {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    // Jugador j = jugador.get(viewHolder.getAdapterPosition());
                    // JugadorController.borrarJugador(j);
                    jugadores.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    jugadores.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_jugadores);
    }

    private void mostrarToast(String texto)
    {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }
}

