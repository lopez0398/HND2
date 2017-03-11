package com.daniel.hnd2.beans;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 09/03/2017.
 */

public class PersonajeBean  implements Serializable{

    private int imgPersonaje;
    private String nombre, descripcion, poder, arma;

    public PersonajeBean() {
    }

    public PersonajeBean(String nombre, String descripcion, String poder, String arma, int imgPersonaje) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.poder = poder;
        this.arma = arma;
        this.imgPersonaje = imgPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public int getImgPersonaje() {
        return imgPersonaje;
    }

    public void setImgPersonaje(int imgPersonaje) {
        this.imgPersonaje = imgPersonaje;
    }
}
