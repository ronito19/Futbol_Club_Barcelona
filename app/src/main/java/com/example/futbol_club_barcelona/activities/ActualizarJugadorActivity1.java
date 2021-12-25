package com.example.futbol_club_barcelona.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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

public class ActualizarJugadorActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public static final String EXTRA_OBJETO_JUGADOR = "es.ronito19.actualizarjugador1.objeto_jugador";
    private Spinner sp_actualizarj = null;
    JugadorViewModel mJugadorViewModel = null;
    static Jugador jseleccionado = null;
    static ArrayAdapter<Jugador> adapter = null;
    LiveData<List<Jugador>> jugadores = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_jugador1);
        sp_actualizarj = (Spinner) findViewById(R.id.sp_actualizarj);
        sp_actualizarj.setOnItemSelectedListener(this);
        mJugadorViewModel = new ViewModelProvider(this).get(JugadorViewModel.class);
        //---------------------------------------------------------------------------------------

        LiveData<List<Jugador>> jugadoresLive = mJugadorViewModel.obtenerjugadores();
        if(jugadoresLive != null) {
            jugadoresLive.observe(this, new Observer<List<Jugador>>() {
                @Override
                public void onChanged(@Nullable final List<Jugador> jugadors) {
                    asignarAdaptadorSpinnerProvincias(jugadors);
                }
            });
        }
        else{
            Toast.makeText(this, "no se han recuperado provincias", Toast.LENGTH_SHORT).show();
        }
    }

    private void asignarAdaptadorSpinnerProvincias(List<Jugador> jugadors) {
        adapter = new ArrayAdapter<Jugador>(this , R.layout.item_jugador, jugadors);
        sp_actualizarj.setAdapter(adapter);
    }


    public void siguienteactualizarProvincia(View view) {
        if(jseleccionado == null)
        {
            mostrarToast("selecciona una provincia");
            return;
        }

        Intent intent = new Intent(this, ActualizarJugadorActivity2.class);
        intent.putExtra(EXTRA_OBJETO_JUGADOR, jseleccionado);
        // Toast.makeText(this,"la provincia seleccionada es " +pseleccionada.getNombre(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Jugador j = (Jugador) sp_actualizarj.getItemAtPosition(position);
        jseleccionado = j;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void siguienteactualizarprovincia1(View view) {
        if(jseleccionado == null)
        {
            mostrarToast("selecciona un curso");
            return;
        }

        Intent intent = new Intent(this, ActualizarJugadorActivity2.class);
        intent.putExtra(EXTRA_OBJETO_JUGADOR, jseleccionado);
        // Toast.makeText(this,"la provincia seleccionada es " +pseleccionada.getNombre(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


    private void mostrarToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }


}