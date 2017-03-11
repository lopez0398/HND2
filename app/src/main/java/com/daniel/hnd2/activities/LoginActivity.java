package com.daniel.hnd2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.hnd2.MainActivity;
import com.daniel.hnd2.Preferencias;
import com.daniel.hnd2.R;
import com.daniel.hnd2.beans.UsuarioBean;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUsuario, editPassword;
    private Button btn_login, btn_registro;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Preferencias preferencias = new Preferencias(LoginActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(preferencias.isLogin() == false){

            editUsuario = (EditText) findViewById(R.id.editUsuario);
            editPassword = (EditText) findViewById(R.id.editPassword);
            btn_login = (Button) findViewById(R.id.btn_login);
            btn_registro = (Button) findViewById(R.id.btn_registro);

            btn_login.setOnClickListener(this);
            btn_registro.setOnClickListener(this);

        } else {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String usuario = editUsuario.getText().toString();
                String password = editPassword.getText().toString();

                if (usuario != null && password != null && !usuario.isEmpty() && !password.isEmpty()) {
                    Preferencias preferencias = new Preferencias(LoginActivity.this);
                    UsuarioBean usuarioBean = preferencias.getUsuario();
                    if (usuarioBean.getUsuario() != null) {
                        if (usuario.equals(usuarioBean.getUsuario()) && password.equals(usuarioBean.getContraseña())) {
                            preferencias.setLogin(true);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "No existe el usuario", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Datos obligatorios", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_registro:
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                break;
        }
    }
}
