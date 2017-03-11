package com.daniel.hnd2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.ObjetoBean;
import com.daniel.hnd2.beans.TipBean;
import com.daniel.hnd2.fragments.ObjetosFragment;
import com.daniel.hnd2.fragments.TipsFragment;

public class TipActivity extends AppCompatActivity {

    private TextView txtTitulo, txtDetalle;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtDetalle = (TextView) findViewById(R.id.txtDetalle);

        TipBean tipBean = (TipBean) getIntent().getSerializableExtra(TipsFragment.TIP_KEY);

        txtTitulo.setText(tipBean.getTitulo());
        txtDetalle.setText(tipBean.getDetalle());


    }
}
