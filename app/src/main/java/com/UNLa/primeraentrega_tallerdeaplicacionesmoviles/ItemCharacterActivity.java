package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ItemCharacterActivity extends AppCompatActivity {

    Toolbar my_toolbar;
    TextView tvName,tvGender,tvCulture,tvBorn,tvDied,
            tvTitles,tvFather,tvMother,tvSpouse,
            tvTvSeries,tvPlayedBy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_personaje);

        tvName = findViewById(R.id.tvName);
        tvGender = findViewById(R.id.tvGender);
        tvCulture = findViewById(R.id.tvCulture);
        tvBorn = findViewById(R.id.tvBorn);
        tvDied = findViewById(R.id.tvDied);
        tvTitles = findViewById(R.id.tvTitles);
        tvFather = findViewById(R.id.tvFather);
        tvMother = findViewById(R.id.tvMother);
        tvSpouse = findViewById(R.id.tvSpouse);
        tvTvSeries = findViewById(R.id.tvTvSeries);
        tvPlayedBy = findViewById(R.id.tvPlayedBy);

        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Characters");

        //ACA MOSTRARIA AL PERSONAJE
        showElement();

    }

    private void showElement(){
        Character character = (Character) getIntent().getExtras().get("character");
        tvName.setText(tvName.getText()+character.getName());
        tvGender.setText(tvGender.getText()+character.getGender());
        tvCulture.setText(tvCulture.getText()+character.getCulture());
        tvBorn.setText(tvBorn.getText()+character.getBorn());
        tvDied.setText(tvDied.getText()+character.getDied());
        if(character.getTitles() != null){
            String titles = String.join(",", character.getTitles());
            tvTitles.setText(tvTitles.getText()+titles);
        }
        tvFather.setText(tvFather.getText()+character.getDied());
        tvMother.setText(tvMother.getText()+character.getMother());
        tvSpouse.setText(tvSpouse.getText()+character.getSpouse());
        if(character.getTvSeries() != null){
            String tvSeries = String.join(",", character.getTvSeries());
            tvTvSeries.setText(tvTvSeries.getText()+tvSeries);
        }
        tvPlayedBy.setText(tvPlayedBy.getText()+character.getPlayedBy());

    }
}