package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ItemCharacterActivity extends AppCompatActivity {

    Toolbar my_toolbar;
    TextView tvName, tvGender, tvCulture, tvBorn, tvDied,
            tvFather, tvMother, tvSpouse;
    Button btVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_personaje);

        tvName = findViewById(R.id.tvName);
        tvGender = findViewById(R.id.tvGender);
        tvCulture = findViewById(R.id.tvCulture);
        tvBorn = findViewById(R.id.tvBorn);
        tvDied = findViewById(R.id.tvDied);
        tvFather = findViewById(R.id.tvFather);
        tvMother = findViewById(R.id.tvMother);
        tvSpouse = findViewById(R.id.tvSpouse);


        btVolver = findViewById(R.id.btVolver);
        my_toolbar = findViewById(R.id.tbTittle);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setTitle("Characters");

        showElement();

    }

    private void showElement() {
        Character character = (Character) getIntent().getExtras().get("character");
        tvName.setText(tvName.getText() + character.getName());
        tvGender.setText(tvGender.getText() + character.getGender());
        tvCulture.setText(tvCulture.getText() + character.getCulture());
        tvBorn.setText(tvBorn.getText() + character.getBorn());
        tvDied.setText(tvDied.getText() + character.getDied());
        tvFather.setText(tvFather.getText() + character.getFather());
        tvMother.setText(tvMother.getText() + character.getMother());
        tvSpouse.setText(tvSpouse.getText() + character.getSpouse());

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemCharacterToMenuActivity = new Intent(ItemCharacterActivity.this, MainActivity2.class);
                startActivity(itemCharacterToMenuActivity);
                finish();
            }
        });
    }
}