package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.sql.SQLException;

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


        SharedPreferences credentials = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENTIAL, MODE_PRIVATE);
        //Aca le digo que men traiga lo que esta guardado y en el caso que no exista le digo que traiga nulo.
        String usuarioGuardado = credentials.getString(Constantes.USUARIO, null);
        String passwordGuardado = credentials.getString(Constantes.PASSWORD, null);

        //Si hay algo guardado pasa a la otra vista
        if (usuarioGuardado != null && passwordGuardado != null) {
            iniciarMainActivity(usuarioGuardado);
        }

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();
                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginAndRegisterActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_LONG).show();
                } else {
                    Intent loginToMenu = new Intent(LoginAndRegisterActivity.this, MainActivity2.class);//aca cambie
                    loginToMenu.putExtra("usuario", usuario); //un bundle puede llamar a este extra identificado como usuario.
                    startActivity(loginToMenu);
                    finish();
                    loginPrimeraVezConCheckBoxActivado(usuario, password);
                }}});

                /*if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginAndRegisterActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Usuario user = UsuarioManager.getInstancia(LoginAndRegisterActivity.this).getUsuario(usuario);
                        if(user.contrasena.equals(password)){
                            loginPrimeraVezConCheckBoxActivado(usuario, password);
                        }
                        else {
                            System.out.println("hola");
                            Toast.makeText(LoginAndRegisterActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });*/


        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                Usuario usuarioARegistrar = new Usuario(usuario, password);

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginAndRegisterActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_LONG).show();
                } else {

                    try {
                        UsuarioManager.getInstancia(LoginAndRegisterActivity.this).newUsuario(usuarioARegistrar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent loginAndRegisterToRegister = new Intent(LoginAndRegisterActivity.this, RegisterActivity.class);
                    loginAndRegisterToRegister.putExtra("usuario", usuario); //un bundle puede llamar a este extra identificado como usuario.
                    startActivity(loginAndRegisterToRegister);
                    finish();
                }
            }
        });
    }

    //Esto se llama cuando es usuario esta guardado o cuando no esta guardado pero tmp quiero guardarlo con el checkbok.
    private void iniciarMainActivity(String usuario) {
        Intent loginToList = new Intent(LoginAndRegisterActivity.this,
                MainActivity2.class);
        loginToList.putExtra(Constantes.USUARIO, usuario); //un bundle puede llamar a este extra identificado como usuario.
        startActivity(loginToList);
        finish();
    }

    //Si no  hay algo guardado pregunta si esta seleccionado el schecked y si esta seleccionado lo guarda en constantes
    public void loginPrimeraVezConCheckBoxActivado(String usuario, String password) {
        if (cbRecordarUsuario.isChecked()) {
            SharedPreferences credentials = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENTIAL, MODE_PRIVATE);
            SharedPreferences.Editor editor = credentials.edit();
            editor.putString(Constantes.USUARIO, usuario);
            editor.putString(Constantes.PASSWORD, password);
            editor.apply();
        }
        //si no va a la otra pantalla
        iniciarMainActivity(usuario);
    }
}