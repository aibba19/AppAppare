package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class offertaSalvata extends AppCompatActivity {

TextView nome;
TextView contenuto;
ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offerta_salvata);

        nome = findViewById(R.id.nomeOfferta);
        contenuto = findViewById(R.id.contenutoOfferta);
        foto = findViewById(R.id.fotoOfferta);

        Intent intent = getIntent();

        nome.setText(intent.getStringExtra("nome"));
        contenuto.setText(intent.getStringExtra("contenuto"));
        foto.setImageResource(intent.getIntExtra("foto", 0));

    }
}
