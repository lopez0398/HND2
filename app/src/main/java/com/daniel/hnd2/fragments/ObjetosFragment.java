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

import com.daniel.hnd2.R;
import com.daniel.hnd2.activities.ObjetoActivity;
import com.daniel.hnd2.adapters.ObjetosAdapter;
import com.daniel.hnd2.beans.ObjetoBean;
import com.daniel.hnd2.test.ModeloObjeto;

import java.util.ArrayList;

public class ObjetosFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listObjetos;
    private ArrayList<ObjetoBean> objetos;
    public static final String OBJETO_KEY="OBJETO_KEY";

    public ObjetosFragment() {
        // Required empty public constructor
    }

    public static ObjetosFragment newInstance() {
        return new ObjetosFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_objetos, container, false);

        listObjetos = (ListView) view.findViewById(R.id.listObjetos);
        objetos = ModeloObjeto.getObjetos();

        ObjetosAdapter adapter = new ObjetosAdapter(getActivity(), R.layout.item, objetos);
        listObjetos.setAdapter(adapter);
        listObjetos.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        ObjetoBean objetoBean = objetos.get(posicion);
        Intent intent = new Intent(getActivity(), ObjetoActivity.class);
        intent.putExtra(OBJETO_KEY, objetoBean);

        startActivity(intent);
    }
}
