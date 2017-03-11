package com.daniel.hnd2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daniel.hnd2.Preferencias;
import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.UsuarioBean;

public class AjustesFragment extends Fragment {

    public AjustesFragment() {
        // Required empty public constructor
    }

    public static AjustesFragment newInstance(){
        return new AjustesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_ajustes, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
