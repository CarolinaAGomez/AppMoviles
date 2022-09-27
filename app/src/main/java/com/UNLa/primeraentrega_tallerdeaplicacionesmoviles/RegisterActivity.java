package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    TextView confirmarUsuario;
    Button backLogin, btUsuariosRegistrados;
    Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        confirmarUsuario = findViewById(R.id.tvConfirmarUsuario);
        backLogin = findViewById(R.id.btBackLogin);
        btUsuariosRegistrados = findViewById(R.id.btUsuariosRegistrados);

        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Register");

        confirmarUsuario();

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerAndLoginAndRegister = new Intent(RegisterActivity.this, LoginAndRegisterActivity.class);
                startActivity(registerAndLoginAndRegister);
            }
        });

        btUsuariosRegistrados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerToUsarios = new Intent(RegisterActivity.this, UsuariosRegistrados.class);
                startActivity(registerToUsarios);
            }
        });
    }

    private void confirmarUsuario() {
        Bundle bundle = getIntent().getExtras(); //Llama a todos los bundles de las clases que tienen extras como el usuario.

        if (bundle != null) {
            String usuario = bundle.getString("usuario");
            confirmarUsuario.setText("Usuario " + usuario + " registrado correctamente");
        }
    }
}