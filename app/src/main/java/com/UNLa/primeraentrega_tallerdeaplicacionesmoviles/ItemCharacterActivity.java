package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ItemCharacterActivity extends AppCompatActivity {

    Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_personaje);


        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Characters");

        //ACA MOSTRARIA AL PERSONAJE
    }
}