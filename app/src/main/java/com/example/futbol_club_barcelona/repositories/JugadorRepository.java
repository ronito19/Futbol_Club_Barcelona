package com.example.futbol_club_barcelona.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.dao.DAOJugador;
import com.example.futbol_club_barcelona.repositories.tareas.TareaActualizarJugador;
import com.example.futbol_club_barcelona.repositories.tareas.TareaBorrarJugador;
import com.example.futbol_club_barcelona.repositories.tareas.TareaInsertarJugador;
import com.example.futbol_club_barcelona.repositories.tareas.TareaObtenerJugadores;
import com.example.futbol_club_barcelona.roomDatabase.InstitutoRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("unchecked")

public class JugadorRepository {
    public static DAOJugador mjugadorDAO;
    private LiveData<List<Jugador>> mAlljugadores;


    public JugadorRepository(Application application) {
        InstitutoRoomDatabase db = InstitutoRoomDatabase.getDatabase(application);
        mjugadorDAO = db.jugadorDAO();
        mAlljugadores = mjugadorDAO.cogerTodosLosJugadores();
    }


    public LiveData<List<Jugador>> getAllJugadores() {
        return mAlljugadores;
    }

    //---------------------------------------------------------------------------


    public static boolean insertarJugador(Jugador j) {
        FutureTask t = new FutureTask(new TareaInsertarJugador(j));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return insercionOK;
        }
    }
    //-------------------------------------------------------------------------------------


    public static LiveData<List<Jugador>> obtenerJugadores() {
        LiveData<List<Jugador>> jugadoresDevueltos = null;
        FutureTask t = new FutureTask(new TareaObtenerJugadores());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            jugadoresDevueltos = (LiveData<List<Jugador>>) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return jugadoresDevueltos;
    }
    //---------------------------------------------------------------------------


    public static boolean borrarJugador(Jugador j) {
        FutureTask t = new FutureTask(new TareaBorrarJugador(j));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return borradoOK;
        }

        //-------------------------------------------------------------------------------

    }

    public boolean actualizarJugador(Jugador j)
    {
        FutureTask t = new FutureTask(new TareaActualizarJugador(j));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }
}
    //-----------------------------------------------------------------------------------