package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Distanza extends AppCompatActivity {

    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;
    private Button risultati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distanza);

        indietro = (ImageButton) findViewById(R.id.backBtn);
        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        home = (ImageButton) findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        profilo = (ImageButton) findViewById(R.id.profileBtn);
        profilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProfilo();
            }
        });

        risultati = (Button) findViewById(R.id.risultatibtn);
        risultati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goRisultati();
            }
        });


    }

    public void goHome() {
        Intent casa = new Intent(this, HomepageActivity.class);
        startActivity(casa);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void goProfilo() {
        Intent profilo = new Intent(this, Profilo.class);
        startActivity(profilo);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void goBack() {
        Intent indietro = new Intent(this, SelectFoodActivity.class);
        startActivity(indietro);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void goRisultati() {
        Intent res = new Intent(this, ListaRisultati.class);
        startActivity(res);
    }
}
