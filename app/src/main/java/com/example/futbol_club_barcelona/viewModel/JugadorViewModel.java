package com.example.futbol_club_barcelona.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.futbol_club_barcelona.activities.ActualizarJugadorActivity1;
import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.repositories.JugadorRepository;

import java.util.List;
import java.util.Objects;


public class JugadorViewModel extends AndroidViewModel
{
    private JugadorRepository mRepository;
    private LiveData<List<Jugador>> mAllJugadores;



    public JugadorViewModel(@NonNull Application application) {
        super(application);
        mRepository = new JugadorRepository(application);
        mAllJugadores = mRepository.getAllJugadores();
    }



    public LiveData<List<Jugador>> obtenerjugadores()
    {
        LiveData<List<Jugador>> mAllJugadores = mRepository.getAllJugadores();
        return mAllJugadores;
    }



    public boolean insertarJugador(Jugador j) {
        boolean insercionOK = mRepository.insertarJugador(j);
        return insercionOK;
    }



    public boolean borrarJugador(Jugador j)
    {
        boolean borradoOK = mRepository.borrarJugador(j);
        return borradoOK;
    }



    public  boolean actualizarJugador(Jugador j)
    {
        boolean actualizacionOK = mRepository.actualizarJugador(j);
        return actualizacionOK;
    }
}
