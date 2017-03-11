package com.daniel.hnd2.beans;

import java.io.Serializable;

/**
 * Created by danis on 11/03/2017.
 */

public class TipBean implements Serializable{

    private String titulo, detalle;

    public TipBean() {

    }

    public TipBean(String titulo, String detalle) {
        this.titulo = titulo;
        this.detalle = detalle;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
