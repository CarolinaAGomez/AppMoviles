package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
    Button btSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Lista de personajes");

        setupAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if(item.getItemId() == R.id.item_main_characters){
            Toast.makeText(this, "Ya estás en esta pestaña", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.item_house){
            Toast.makeText(this, "Casas", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.item_logout){
            Intent itemCharacterToMenuActivity = new Intent(MainActivity.this, ViewPrincipalActivity.class);
            startActivity(itemCharacterToMenuActivity);
            SharedPreferences credentials = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENTIAL, MODE_PRIVATE);
            SharedPreferences.Editor editor = credentials.edit();
            editor.putString(Constantes.USUARIO, null);
            editor.putString(Constantes.PASSWORD, null);
            editor.apply();
            finish();
        }
        return super.onOptionsItemSelected(item);
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
            }
        });
        recyclerView.setAdapter(characterAdapter);
    }

    private List<Character> getcharacter() {
        List<Character> characters = new ArrayList<>();
        characters.add(new Character(25, "Corlys Velaryon", "Male", "Valyrian", "In 53 AC", "In 132 AC"));
        characters.add(new Character(42, "Aegon Targaryen", "Male", "Valyrian", "In 281 AC or 282 ACC", "In 283 AC"));
        characters.add(new Character(55, "Aemond Targaryen", "Male", "Valyrian", "In 110 AC", "In 130 AC"));
        characters.add(new Character(1527, "Jaehaera Targaryen", "Female", "Valyrian", "In 123 AC", "In 133 AC"));
        return characters;
    }
}