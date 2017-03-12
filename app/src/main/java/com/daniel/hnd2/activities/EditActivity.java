package com.daniel.hnd2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.hnd2.Preferencias;
import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.UsuarioBean;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre, editApellidos, editUsuario, editPassword;
    private Button btn_cambios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellidos = (EditText) findViewById(R.id.editApellidos);
        editUsuario = (EditText) findViewById(R.id.editUsuario);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btn_cambios = (Button) findViewById(R.id.btn_cambios);

        Preferencias preferencias = new Preferencias(EditActivity.this);
        UsuarioBean usuarioBean = preferencias.getUsuario();

        editNombre.setText(usuarioBean.getNombre());
        editApellidos.setText(usuarioBean.getApellidos());
        editUsuario.setText(usuarioBean.getUsuario());

        btn_cambios.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nombre = editNombre.getText().toString();
        String apellidos = editApellidos.getText().toString();
        String usuario = editUsuario.getText().toString();
        String password = editPassword.getText().toString();

        if(nombre != null && !nombre.isEmpty() &&
                apellidos != null && !apellidos.isEmpty() &&
                usuario != null && !usuario.isEmpty() &&
                password != null && !password.isEmpty()) {
            UsuarioBean usuarioBean = new UsuarioBean(nombre, apellidos, usuario, password);

            Preferencias preferencias = new Preferencias(EditActivity.this);
            preferencias.setUsuario(usuarioBean);

            Toast.makeText(EditActivity.this,
                    "Los cambios se han guardado correctamente",
                    Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(EditActivity.this, "Datos obligatorios", Toast.LENGTH_SHORT).show();
        }
    }
}
