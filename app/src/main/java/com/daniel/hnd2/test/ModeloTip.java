package com.daniel.hnd2.test;

import com.daniel.hnd2.beans.TipBean;

import java.util.ArrayList;

public class ModeloTip {

    public static ArrayList<TipBean> getTips(){

        ArrayList<TipBean> tips = new ArrayList<>();

        tips.add(new TipBean("Nuevas naves", "En la última versión del videojuego ya están disponibles las 3 nuevas naves."));
        tips.add(new TipBean("Actualización 1.1", "Mejora en la fluidez del juego y arreglo de algunos bugs que se encontraron en la anterior versión."));

        return tips;

    }
}
