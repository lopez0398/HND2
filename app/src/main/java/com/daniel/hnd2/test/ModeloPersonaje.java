package com.daniel.hnd2.test;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.PersonajeBean;

import java.util.ArrayList;


public class ModeloPersonaje {

    public static ArrayList<PersonajeBean> getPersonajes(){

        ArrayList<PersonajeBean> personajes = new ArrayList<>();

        personajes.add(new PersonajeBean("Nave x-wing", "Nave principal del videojuego, nuestro personaje", "Disparos desde sus cuatro alas", "Cañones en cada una de sus cuatro alas", R.drawable.xwing));
        personajes.add(new PersonajeBean("Nave de Star Trek", "El enemigo 'jefe' del videojuego, aparece después de derrotar a un número determinado de enemigos", "Rayos desde sus dos cañones", "Cañón", R.drawable.navestartrek));
        personajes.add(new PersonajeBean("Nave Piranha", "Nave del videojuego WipEout HD", "Diferentes disparos desde su parte delantera", "", R.drawable.piranhaprincipal));

        return personajes;

    }
}
