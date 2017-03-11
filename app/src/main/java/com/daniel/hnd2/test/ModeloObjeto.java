package com.daniel.hnd2.test;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.ObjetoBean;
import com.daniel.hnd2.beans.PersonajeBean;

import java.util.ArrayList;


public class ModeloObjeto {

    public static ArrayList<ObjetoBean> getObjetos(){

        ArrayList<ObjetoBean> objetos = new ArrayList<>();

        objetos.add(new ObjetoBean(R.drawable.xwing,"Nave x-wing", "Nave principal del videojuego, nuestro personaje"));

        return objetos;

    }
}
