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

import com.daniel.hnd2.R;


public class DescripcionFragment extends Fragment implements View.OnClickListener {

    private ImageButton btn_compartir, btn_twitter, btn_facebook, btn_whatsapp;
    private TextView txtDescripcion;

    private String descripcion;

    public DescripcionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_descripcion, container, false);

        descripcion = "Juego de naves para dispositivos móviles.";

        txtDescripcion = (TextView) view.findViewById(R.id.txtDescripcion);
        btn_compartir = (ImageButton) view.findViewById(R.id.btn_compartir);
        btn_twitter = (ImageButton) view.findViewById(R.id.btn_twitter);
        btn_facebook = (ImageButton) view.findViewById(R.id.btn_facebook);
        btn_whatsapp = (ImageButton) view.findViewById(R.id.btn_whatsapp);

        txtDescripcion.setText(descripcion);

        btn_compartir.setOnClickListener(this);
        btn_twitter.setOnClickListener(this);
        btn_facebook.setOnClickListener(this);
        btn_whatsapp.setOnClickListener(this);


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

    public static DescripcionFragment newInstance() {
        return new DescripcionFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_compartir:
                Intent intentCompartir = new Intent(Intent.ACTION_SEND);
                intentCompartir.setType("text/plain");
                intentCompartir.putExtra(Intent.EXTRA_TEXT, descripcion);
                startActivity(Intent.createChooser(intentCompartir, "Compartir en..."));
                break;

            case R.id.btn_twitter:
                Intent intentTwitter = new Intent(Intent.ACTION_SEND);
                intentTwitter.setType("text/plain");
                intentTwitter.putExtra(Intent.EXTRA_TEXT, descripcion);
                intentTwitter.setPackage("com.twitter.android");
                startActivity(intentTwitter);
                break;

            case R.id.btn_facebook:
                Intent intentFacebook = new Intent(Intent.ACTION_SEND);
                intentFacebook.setType("text/plain");
                intentFacebook.putExtra(Intent.EXTRA_TEXT, descripcion);
                intentFacebook.setPackage("com.facebook.katana");
                startActivity(intentFacebook);
                break;

            case R.id.btn_whatsapp:
                Intent intentWhatsapp = new Intent(Intent.ACTION_SEND);
                intentWhatsapp.setType("text/plain");
                intentWhatsapp.putExtra(Intent.EXTRA_TEXT, descripcion);
                intentWhatsapp.setPackage("com.whatsapp");
                startActivity(intentWhatsapp);
                break;
        }
    }
}
