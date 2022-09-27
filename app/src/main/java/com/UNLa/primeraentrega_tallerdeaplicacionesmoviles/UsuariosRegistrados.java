package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsuariosRegistrados extends AppCompatActivity {


    RecyclerView recyclerView;
    UsuarioAdapter usuarioAdapter;
    Button btVolverLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_registrados);
        btVolverLogin = findViewById(R.id.btVolverLogin);

        setupAdapter();

        btVolverLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listUsuariosToLogin = new Intent(UsuariosRegistrados.this, LoginAndRegisterActivity.class);
                startActivity(listUsuariosToLogin);
            }
        });
    }

    public List<Usuario> getUsuario() {
        try {
            List<Usuario> list = UsuarioManager.getInstancia(UsuariosRegistrados.this).getUsuarios();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();//lista vacia
        }
    }

    private void setupAdapter() {
        recyclerView = findViewById(R.id.rvReclyclerUsuario);
        usuarioAdapter = new UsuarioAdapter(getUsuario(), new UsuarioAdapter.OnItemClickListener() {
            @Override
            public void onItemClickLIstener(Usuario usuario) {
                Toast.makeText(UsuariosRegistrados.this, usuario.getUsuario(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(usuarioAdapter);
    }

}