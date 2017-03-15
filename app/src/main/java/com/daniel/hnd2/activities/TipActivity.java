package com.daniel.hnd2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.ObjetoBean;
import com.daniel.hnd2.beans.TipBean;
import com.daniel.hnd2.fragments.ObjetosFragment;
import com.daniel.hnd2.fragments.TipsFragment;

public class TipActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtTitulo, txtDetalle;
    private ImageButton btn_compartir, btn_twitter, btn_facebook, btn_whatsapp;

    private String detalle;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TipBean tipBean = (TipBean) getIntent().getSerializableExtra(TipsFragment.TIP_KEY);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtDetalle = (TextView) findViewById(R.id.txtDetalle);
        btn_compartir = (ImageButton) findViewById(R.id.btn_compartir);
        btn_twitter = (ImageButton) findViewById(R.id.btn_twitter);
        btn_facebook = (ImageButton) findViewById(R.id.btn_facebook);
        btn_whatsapp = (ImageButton) findViewById(R.id.btn_whatsapp);

        btn_compartir.setOnClickListener(this);
        btn_twitter.setOnClickListener(this);
        btn_facebook.setOnClickListener(this);
        btn_whatsapp.setOnClickListener(this);

        detalle = "Titulo: " + tipBean.getTitulo() + ", Detalle: " + tipBean.getDetalle();

        txtTitulo.setText(tipBean.getTitulo());
        txtDetalle.setText(tipBean.getDetalle());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_compartir:

                Intent intentCompartir = new Intent(Intent.ACTION_SEND);
                intentCompartir.setType("text/plain");
                intentCompartir.putExtra(Intent.EXTRA_TEXT, detalle);
                startActivity(Intent.createChooser(intentCompartir, "Compartir en..."));
                break;

            case R.id.btn_twitter:
                Log.d("pulsado","pulsado");
                Intent intentTwitter = new Intent(Intent.ACTION_SEND);
                intentTwitter.setType("text/plain");
                intentTwitter.putExtra(Intent.EXTRA_TEXT, detalle);
                intentTwitter.setPackage("com.twitter.android");
                startActivity(intentTwitter);
                break;

            case R.id.btn_facebook:
                Intent intentFacebook = new Intent(Intent.ACTION_SEND);
                intentFacebook.setType("text/plain");
                intentFacebook.putExtra(Intent.EXTRA_TEXT, detalle);
                intentFacebook.setPackage("com.facebook.katana");
                startActivity(intentFacebook);
                break;

            case R.id.btn_whatsapp:
                Intent intentWhatsapp = new Intent(Intent.ACTION_SEND);
                intentWhatsapp.setType("text/plain");
                intentWhatsapp.putExtra(Intent.EXTRA_TEXT, detalle);
                intentWhatsapp.setPackage("com.whatsapp");
                startActivity(intentWhatsapp);
                break;
        }
    }
}
