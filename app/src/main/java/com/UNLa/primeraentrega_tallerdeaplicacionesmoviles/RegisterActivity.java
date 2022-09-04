package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class RegisterActivity extends AppCompatActivity {

    TextView confirmarUsuario;
    Button backLogin;
    Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        confirmarUsuario = findViewById(R.id.tvConfirmarUsuario);
        backLogin = findViewById(R.id.btBackLogin);

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
    }


    private void confirmarUsuario() {
        confirmarUsuario.setText("Se registro el usuario correctamente");
        Bundle bundle = getIntent().getExtras(); //Llama a todos los bundles de las clases que tienen extras como el usuario.

        if (bundle != null) {
            String usuario = bundle.getString("usuario");
            Toast.makeText(RegisterActivity.this, "Bienvenida/o usuario" + usuario, Toast.LENGTH_SHORT).show();
        }
    }
}