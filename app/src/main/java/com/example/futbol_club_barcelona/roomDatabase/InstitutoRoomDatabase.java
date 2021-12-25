package com.example.futbol_club_barcelona.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.dao.DAOJugador;


@Database(entities = {Jugador.class}, version = 1, exportSchema = false)
public abstract class InstitutoRoomDatabase extends RoomDatabase
{
    public abstract DAOJugador jugadorDAO();
    private static InstitutoRoomDatabase INSTANCE;



    public static InstitutoRoomDatabase getDatabase(final Context context)
        {
            if (INSTANCE == null)
            {
                synchronized (InstitutoRoomDatabase.class)
                {
                    if (INSTANCE == null)
                    {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                InstitutoRoomDatabase.class, "instituto_database")
                                // Wipes and rebuilds instead of migrating
                                // if no Migration object.
                                // Migration is not part of this practical.
                                .fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }

}
