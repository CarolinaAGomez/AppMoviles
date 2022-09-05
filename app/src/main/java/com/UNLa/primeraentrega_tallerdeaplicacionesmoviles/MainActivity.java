package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CharacterAdapter characterAdapter;
    Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Main Activity");

        setupAdapter();
    }

    private void setupAdapter() {
        recyclerView = findViewById(R.id.rvReclyclerMain);
        characterAdapter = new CharacterAdapter(getcharacter(), new CharacterAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(Character character) {
                Intent mainActivityToItemCharacter = new Intent(MainActivity.this, ItemCharacterActivity.class);
                mainActivityToItemCharacter.putExtra("character", character);
                startActivity(mainActivityToItemCharacter);
                finish();
                //Toast.makeText(MainActivity.this, character.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(characterAdapter);
    }

    private List<Character> getcharacter() {
        List<Character> characters = new ArrayList<>();
        characters.add(new Character(1, "Joffrey Lonmouth","Male", ""));
        characters.add(new Character(2, "Jon Snow","Male", "Northmen"));
        characters.add(new Character(3, "Aeron Greyjoy","Male", "Ironborn"));
        characters.add(new Character(4, "Robert I Baratheon","Male", "prueba4"));
        characters.add(new Character());
        return characters;
    }
}