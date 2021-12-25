package com.example.futbol_club_barcelona.clases;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "jugadores")

public class Jugador implements Serializable {
    //--------------------------------------------------------------------------------------------

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "posicion")
    private String posicion;

    @NonNull
    @ColumnInfo(name = "edad")
    private int edad;

    @NonNull
    @ColumnInfo(name = "sueldo")
    private double sueldo;

    @NonNull
    @ColumnInfo(name = "numeroCam")
    private int numeroCam;
    //--------------------------------------------------------------------------------------------


    public Jugador(@NonNull String nombre, @NonNull String posicion, int edad, double sueldo, int numeroCam) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
        this.sueldo = sueldo;
        this.numeroCam = numeroCam;
    }
    //-------------------------------------------------------------------------------------------


    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(@NonNull String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getNumeroCam() {
        return numeroCam;
    }

    public void setNumeroCam(int numeroCam) {
        this.numeroCam = numeroCam;
    }
    //-----------------------------------------------------------------------------------------


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador jugador = (Jugador) o;
        return numeroCam == jugador.numeroCam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCam);
    }
    //--------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return nombre;
    }



}
