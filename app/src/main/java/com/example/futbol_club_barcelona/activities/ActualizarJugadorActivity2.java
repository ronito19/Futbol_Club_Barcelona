package com.example.futbol_club_barcelona.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.viewModel.JugadorViewModel;

public class ActualizarJugadorActivity2 extends AppCompatActivity {

    Jugador jseleccionado = null;
    EditText edt_actualizar_jugador = null;
    EditText edt_actualizar_posicion = null;
    EditText edt_actualizar_edad = null;
    EditText edt_actualizar_sueldo = null;
    EditText edt_actualizar_numCam = null;
    JugadorViewModel mJugadorViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_jugador2);
        edt_actualizar_jugador = (EditText) findViewById(R.id.edt_actualizar_jugadorj);
        edt_actualizar_posicion = (EditText) findViewById(R.id.edt_actualizar_posicionj);
        edt_actualizar_edad = (EditText) findViewById(R.id.edt_actualizar_edadj);
        edt_actualizar_sueldo = (EditText) findViewById(R.id.edt_actualizar_sueldoj);
        edt_actualizar_numCam = (EditText) findViewById(R.id.edt_actualizar_numCamj);
        // mProvinciaViewModel = ViewModelProviders.of(this).get(ProvinciaViewModel.class);
        mJugadorViewModel = new ViewModelProvider(this).get(JugadorViewModel.class);

        Intent intent = getIntent();
        if(intent != null)
        {
            jseleccionado = (Jugador) intent.getSerializableExtra(ActualizarJugadorActivity1.EXTRA_OBJETO_JUGADOR);
            if(jseleccionado!=null)
            {
                edt_actualizar_jugador.setText(jseleccionado.getNombre());
                edt_actualizar_jugador.setEnabled(false);
                edt_actualizar_posicion.setText(jseleccionado.getPosicion());
                edt_actualizar_edad.setText(String.valueOf(jseleccionado.getEdad()));
                edt_actualizar_sueldo.setText(String.valueOf(jseleccionado.getSueldo()));
                edt_actualizar_numCam.setText(String.valueOf(jseleccionado.getNumeroCam()));
            }
        }
    }


    public void actualizarJugador2(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("actualizar el jugador?");
        //alerta1.setMessage(" no -> cancelar, si-> actualizar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //actualizar provincia
                String jugador = String.valueOf(edt_actualizar_jugador.getText());
                String posicion = String.valueOf(edt_actualizar_posicion.getText());
                int edad = Integer.parseInt(String.valueOf(edt_actualizar_edad.getText()));
                double sueldo = Double.valueOf(String.valueOf(edt_actualizar_sueldo.getText()));
                int numCam = Integer.parseInt(String.valueOf(edt_actualizar_numCam.getText()));
                Jugador j = new Jugador(jugador, posicion, edad, sueldo, numCam);
                boolean actualizarOK = mJugadorViewModel.actualizarJugador(j);
                // recargar combo (o desde la base de datos volver a solicitar todo, o quitar solamente el item borrado)
                if(actualizarOK)
                {

                    ActualizarJugadorActivity1.adapter.clear();
                    //  LiveData<List<Provincia>> provincias = ProvinciaViewModel.obtenerProvincias();
                    //   ActualizarProvinciaActivity1.adapter.addAll(provincias.getValue());
                    mostrarToast("jugador actualizado correctamente");
                }
                else{
                    mostrarToast("el jugador no se pudo actualizar");
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
