package com.daniel.hnd2.activities;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.PersonajeBean;
import com.daniel.hnd2.fragments.PersonajesFragment;


public class PersonajeActivity extends AppCompatActivity {

    private ImageView imgPersonaje;

    private TextView txtNombre, txtDescripcion, txtPoder, txtArma;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PersonajeBean personajeBean = (PersonajeBean) getIntent().getSerializableExtra(PersonajesFragment.PERSONAJE_KEY);

        imgPersonaje = (ImageView) findViewById(R.id.imgPersonaje);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtPoder = (TextView) findViewById(R.id.txtPoder);
        txtArma = (TextView) findViewById(R.id.txtArma);

        txtNombre.setText(personajeBean.getNombre());
        txtDescripcion.setText(personajeBean.getDescripcion());
        txtPoder.setText(personajeBean.getPoder());
        txtArma.setText(personajeBean.getArma());
        imgPersonaje.setImageDrawable(ContextCompat.getDrawable(this,personajeBean.getImgPersonaje()));
    }
}
