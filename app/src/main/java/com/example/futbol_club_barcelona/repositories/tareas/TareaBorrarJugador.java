package com.example.futbol_club_barcelona.repositories.tareas;

import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.repositories.JugadorRepository;

import java.util.concurrent.Callable;

public class TareaBorrarJugador implements Callable<Boolean>
{
    private Jugador j = null;

    public TareaBorrarJugador(Jugador j) {
        this.j = j;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            JugadorRepository.mjugadorDAO.delete(j);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
