package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginAndRegisterActivity extends AppCompatActivity {

    EditText etUsuario, etPassword;
    CheckBox cbRecordarUsuario;
    Button btLogin, btRegistrar;
    Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);

        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Login and Register");

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etContrasena);
        cbRecordarUsuario = findViewById(R.id.cbRecordar);
        btLogin = findViewById(R.id.btLogin);
        btRegistrar = findViewById(R.id.btRegistrar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginAndRegisterActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_LONG).show();
                } else {
                    Intent loginToMenu = new Intent(LoginAndRegisterActivity.this, MainActivity.class);
                    startActivity(loginToMenu);
                    loginToMenu.putExtra("usuario", usuario); //un bundle puede llamar a este extra identificado como usuario.
                    finish();
                }

            }
        });


        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginAndRegisterActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_LONG).show();
                } else {
                    Intent loginAndRegisterToRegister = new Intent(LoginAndRegisterActivity.this, RegisterActivity.class);
                    startActivity(loginAndRegisterToRegister);
                    loginAndRegisterToRegister.putExtra("usuario", usuario); //un bundle puede llamar a este extra identificado como usuario.
                    finish();
                }
            }
        });
    }
}