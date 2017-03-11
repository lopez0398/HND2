package com.daniel.hnd2.activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.ObjetoBean;
import com.daniel.hnd2.fragments.ObjetosFragment;


public class ObjetoActivity extends AppCompatActivity {

    private ImageView imgObjeto;

    private TextView txtNombre, txtDescripcion;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ObjetoBean objetoBean = (ObjetoBean) getIntent().getSerializableExtra(ObjetosFragment.OBJETO_KEY);

        imgObjeto = (ImageView) findViewById(R.id.imgObjeto);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);

        txtNombre.setText(objetoBean.getNombre());
        txtDescripcion.setText(objetoBean.getDescripcion());
        imgObjeto.setImageDrawable(ContextCompat.getDrawable(this,objetoBean.getImagenObjeto()));
    }
}
