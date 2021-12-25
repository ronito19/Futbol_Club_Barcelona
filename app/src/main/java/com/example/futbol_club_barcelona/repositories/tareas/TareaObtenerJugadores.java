package com.example.futbol_club_barcelona.repositories.tareas;

import androidx.lifecycle.LiveData;

import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.repositories.JugadorRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class TareaObtenerJugadores implements Callable<LiveData<List<Jugador>>> {


    @Override
    public LiveData<List<Jugador>> call() throws Exception {
        try {
            LiveData<List<Jugador>> jugadores = JugadorRepository.mjugadorDAO.cogerTodosLosJugadores();
            return jugadores;
        } catch (Exception e) {
            return null;
        }
    }
}
