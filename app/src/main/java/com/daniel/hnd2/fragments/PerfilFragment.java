package com.daniel.hnd2.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniel.hnd2.activities.EditActivity;
import com.daniel.hnd2.Preferencias;
import com.daniel.hnd2.R;
import com.daniel.hnd2.activities.RegistroActivity;
import com.daniel.hnd2.beans.UsuarioBean;

import java.net.URI;

public class PerfilFragment extends Fragment implements View.OnClickListener {

    private TextView txtNombre, txtApellidos, txtUsuario;
    private ImageButton btn_edit, btn_editImg;
    private ImageView imgPerfil;

    private final int PICTURE_KEY = 1;
    private UsuarioBean usuarioBean;


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
        btn_editImg = (ImageButton) view.findViewById(R.id.btn_editImg);
        imgPerfil = (ImageView) view.findViewById(R.id.imgPerfil);

        Preferencias preferencias = new Preferencias(getActivity());
        usuarioBean = preferencias.getUsuario();

        txtNombre.setText("Nombre: " + usuarioBean.getNombre());
        txtApellidos.setText("Apellidos: " + usuarioBean.getApellidos());
        txtUsuario.setText("Usuario: " + usuarioBean.getUsuario());

        if(usuarioBean.getImgPerfil() == null){
            imgPerfil.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.imagen_usuario));
        }else{
            imgPerfil.setImageURI(Uri.parse(usuarioBean.getImgPerfil()));
        }

        btn_edit.setOnClickListener(this);
        btn_editImg.setOnClickListener(this);

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

        switch (v.getId()){
            case R.id.btn_edit:
                Intent intent = new Intent(getActivity(), EditActivity.class);

                startActivity(intent);

                break;

            case R.id.btn_editImg:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    //Verifica permisos para Android 6.0+
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 225); //Pedimos los permisos para lectura en almacenamiento
                    }
                }
                Intent intentGaleria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intentGaleria.setType("image/*");
                startActivityForResult(intentGaleria.createChooser(intentGaleria,"Selecciona una app de imagen"), PICTURE_KEY);

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case PICTURE_KEY:
                if(resultCode == getActivity().RESULT_OK){
                    Uri path = data.getData();
                    imgPerfil.setImageURI(path);
                    usuarioBean.setImgPerfil(path.toString());
                    Preferencias preferencias = new Preferencias(getActivity());
                    preferencias.setUsuario(usuarioBean);

                }
                break;
        }
    }

}
