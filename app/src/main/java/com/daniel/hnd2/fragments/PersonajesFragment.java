package com.daniel.hnd2.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daniel.hnd2.test.ModeloPersonaje;
import com.daniel.hnd2.R;
import com.daniel.hnd2.activities.PersonajeActivity;
import com.daniel.hnd2.adapters.PersonajesAdapter;
import com.daniel.hnd2.beans.PersonajeBean;

import java.util.ArrayList;

public class PersonajesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listPersonajes;
    private ArrayList<PersonajeBean> personajes;
    public static final String PERSONAJE_KEY="PERSONAJE_KEY";

    public PersonajesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_personajes, container, false);

        listPersonajes = (ListView) view.findViewById(R.id.listPersonajes);
        personajes = ModeloPersonaje.getPersonajes();
        PersonajesAdapter adapter = new PersonajesAdapter(getActivity(), R.layout.item, personajes);
        listPersonajes.setAdapter(adapter);
        listPersonajes.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public static PersonajesFragment newInstance() {
        return new PersonajesFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        PersonajeBean personajeBean = personajes.get(posicion);
        Intent intent = new Intent(getActivity(), PersonajeActivity.class);
        intent.putExtra(PERSONAJE_KEY, personajeBean);

        startActivity(intent);
    }
}
