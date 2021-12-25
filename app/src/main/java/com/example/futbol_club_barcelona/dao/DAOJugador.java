package com.example.futbol_club_barcelona.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.futbol_club_barcelona.clases.Jugador;

import java.util.List;

@Dao
public interface DAOJugador {

    @Insert
    void insert(Jugador jugador);

    @Delete
    void delete(Jugador jugador);

    @Query("DELETE FROM jugadores")
    void deleteAll();

    @Update
    void update(Jugador jugador);

    @Query("SELECT * from jugadores ORDER BY nombre ASC")
    LiveData<List<Jugador>> cogerTodosLosJugadores();


    @Query("SELECT * FROM jugadores WHERE nombre like :jugador")
    LiveData<Jugador> CogerJugador(String jugador);

}
