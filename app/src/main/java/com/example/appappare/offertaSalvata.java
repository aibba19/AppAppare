package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class offertaSalvata extends AppCompatActivity {

    TextView nome;
    TextView contenuto;
    ImageView foto;
    TextView prezzo;
    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offerta_salvata);

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

        nome = findViewById(R.id.nomeOfferta);
        contenuto = findViewById(R.id.contenutoOfferta);
        prezzo=findViewById(R.id.costoOfferta);
        foto = findViewById(R.id.fotoOfferta);

        Intent intent = getIntent();

        nome.setText(intent.getStringExtra("nome"));
        contenuto.setText(intent.getStringExtra("descrizione"));
        prezzo.setText(intent.getStringExtra("prezzo"));
        foto.setImageResource(intent.getIntExtra("foto", 0));

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
        Intent indietro = new Intent(this, ListaOfferteSalvate.class);
        startActivity(indietro);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
