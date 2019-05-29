package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomepageActivity extends AppCompatActivity {
    private ImageButton profile;
    private Button cerca;
    private Button affamato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profile = (ImageButton) findViewById(R.id.profileBtn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProfilo();
            }
        });

        cerca = (Button) findViewById(R.id.cercaButton);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCerca();
            }
        });

        affamato = (Button) findViewById(R.id.affamatoButton);
        affamato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAffamato();
            }
        });
    }

    public void goProfilo() {
        Intent profilo = new Intent(this, Profilo.class);
        startActivity(profilo);
    }

    public void goCerca() {
        Intent search = new Intent(this, SelectFoodActivity.class);
        startActivity(search);
    }

    public void goAffamato() {
        Intent fame = new Intent(this, listaFortunato.class);
        startActivity(fame);
    }
}
