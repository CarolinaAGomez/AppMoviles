package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewPrincipalActivity extends AppCompatActivity {

    TextView tvPrincipal;
    Button btPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_principal);

        tvPrincipal = findViewById(R.id.tvPrincipal);
        btPrincipal = findViewById(R.id.btPrincipal);

        btPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewPrincipalToLoginAndRegister = new Intent(ViewPrincipalActivity.this, LoginAndRegisterActivity.class);
                startActivity(viewPrincipalToLoginAndRegister);
            }
        });
    }

}