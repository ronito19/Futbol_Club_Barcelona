package com.example.futbol_club_barcelona.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.viewModel.JugadorViewModel;

import java.util.List;

public class BorrarJugadorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp_borrar_jugador = null;
    Jugador jseleccionado = null;
    ArrayAdapter<Jugador> adapter = null;
    JugadorViewModel mJugadorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_jugador);
        sp_borrar_jugador = (Spinner) findViewById(R.id.sp_borrar_jugador);
        sp_borrar_jugador.setOnItemSelectedListener(this);
        mJugadorViewModel = new ViewModelProvider(this).get(JugadorViewModel.class);
        //------------------------------------------------------------------------------------

        LiveData<List<Jugador>> jugadoresLive = mJugadorViewModel.obtenerjugadores();
        if(jugadoresLive != null)
        {
            jugadoresLive.observe(this, new Observer<List<Jugador>>() {
                @Override
                public void onChanged(@Nullable final  List<Jugador> jugadors) {
                    asignarAdaptadorSpinnerJugadores(jugadors);
                }
            });
        }
        else{
            Toast.makeText(this, "No se han recuperado jugadores", Toast.LENGTH_SHORT).show();
        }
    }

    private void asignarAdaptadorSpinnerJugadores(List<Jugador> jugadors) {
        adapter = new ArrayAdapter<Jugador>(this , R.layout.item_jugador, jugadors);
        sp_borrar_jugador.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Jugador j = (Jugador) sp_borrar_jugador.getItemAtPosition(position);
        jseleccionado = j;
        //  Toast.makeText(this, p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void borrar_jugador(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("De verdad quieres borrar el jugador?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(jseleccionado == null)
                {
                    mostrarToast("selecciona un jugador");
                    return;
                }
                //borrar provincia
                boolean borradoOK = mJugadorViewModel.borrarJugador(jseleccionado);
                if(borradoOK)
                {
                    mostrarToast(" Jugador borrado correctamente ");
                }
                else{
                    mostrarToast(" El jugador no se pudo borrar ");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
            }

    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
