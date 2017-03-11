package com.daniel.hnd2.beans;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 09/03/2017.
 */

public class ObjetoBean implements Serializable{

    private int imagenObjeto;
    private String nombre, descripcion;

    public ObjetoBean() {

    }

    public ObjetoBean(int imagenObjeto, String nombre, String descripcion) {
        this.imagenObjeto = imagenObjeto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getImagenObjeto() {
        return imagenObjeto;
    }

    public void setImagenObjeto(int imagenObjeto) {
        this.imagenObjeto = imagenObjeto;
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
}
