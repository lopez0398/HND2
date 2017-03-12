package com.daniel.hnd2.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daniel.hnd2.activities.EditActivity;
import com.daniel.hnd2.Preferencias;
import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.UsuarioBean;

public class PerfilFragment extends Fragment implements View.OnClickListener {

    private TextView txtNombre, txtApellidos, txtUsuario;
    private ImageButton btn_edit;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        txtNombre = (TextView) view.findViewById(R.id.txtNombre);
        txtApellidos = (TextView) view.findViewById(R.id.txtApellidos);
        txtUsuario = (TextView) view.findViewById(R.id.txtUsuario);
        btn_edit = (ImageButton) view.findViewById(R.id.btn_edit);

        Preferencias preferencias = new Preferencias(getActivity());
        UsuarioBean usuarioBean = preferencias.getUsuario();

        txtNombre.setText("Nombre: " + usuarioBean.getNombre());
        txtApellidos.setText("Apellidos: " + usuarioBean.getApellidos());
        txtUsuario.setText("Usuario: " + usuarioBean.getUsuario());

        btn_edit.setOnClickListener(this);

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

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), EditActivity.class);
        startActivity(intent);
    }
}
