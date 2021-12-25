package com.example.futbol_club_barcelona.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.futbol_club_barcelona.clases.Jugador;
import com.example.futbol_club_barcelona.viewModel.JugadorViewModel;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.futbol_club_barcelona.R;
import com.example.futbol_club_barcelona.viewModel.JugadorViewModel;

public class NuevoJugadorActivity extends AppCompatActivity {

        private EditText edt_add_nombre;
        private EditText edt_add_posicion;
        private EditText edt_add_edad;
        private EditText edt_add_sueldo;
        private EditText edt_add_numeroCam;
        JugadorViewModel mJugadorViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);
        edt_add_nombre = (EditText)findViewById(R.id.edt_add_nombre);
        edt_add_posicion = (EditText) findViewById(R.id.edt_add_posicion);
        edt_add_edad = (EditText) findViewById(R.id.edt_add_edad);
        edt_add_sueldo = (EditText) findViewById(R.id.edt_add_sueldo);
        edt_add_numeroCam = (EditText) findViewById(R.id.edt_add_numero);
        mJugadorViewModel = new ViewModelProvider(this).get(JugadorViewModel.class);
    }


    public void addjugador(View view) {
        String nombrej = String.valueOf(edt_add_nombre.getText());
        String posicionj = String.valueOf(edt_add_posicion.getText());
        int edadj = Integer.valueOf(String.valueOf(edt_add_edad.getText()));
        double sueldoj = Double.valueOf(String.valueOf(edt_add_sueldo.getText()));
        int numeroCamj = Integer.valueOf(String.valueOf(edt_add_numeroCam.getText()));


        boolean error = false;

        if(nombrej.isEmpty())
        {
            edt_add_nombre.setError(" Debes escribir el nombre de un jugador ");
            error = true;
        }
        if(posicionj.isEmpty())
        {
            edt_add_posicion.setError(" Debes poner la posicion del jugador ");
            error = true;
        }
        if(error)
        {
            return;
        }


        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle(" Quieres guardar el jugador? ");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");

        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener()
        {
            @Override
                public void onClick(DialogInterface dialog, int which) {
                Jugador j = new Jugador(nombrej, posicionj, edadj, sueldoj, numeroCamj);
                boolean insercionOK = mJugadorViewModel.insertarJugador(j);
                mostrarToast(insercionOK);
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });

        alerta1.show();
        }




        public void mostrarToast(boolean insercionOK)
        {
            if(insercionOK)
            {
                Toast.makeText(this," Jugador guardado correctamente", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this," No se pudo guardar el jugador ", Toast.LENGTH_SHORT).show();
            }
        }
}
