package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Profilo extends AppCompatActivity {
    private ImageButton home;
    private Button salvate;
    private TextView nome;
    private String nomeutente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);
        nome = (TextView) findViewById(R.id.nome);
        home = (ImageButton) findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        nome.setText(nomeutente());


        salvate = (Button) findViewById(R.id.listaSalvati);
        salvate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goOfferteSalvate();
            }
        });
    }

    public void goHome() {
        Intent casa = new Intent(this, HomepageActivity.class);
        startActivity(casa);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void goOfferteSalvate() {
        Intent salvate = new Intent(this, ListaOfferteSalvate.class);
        startActivity(salvate);
    }

    public String nomeutente() {
        for (int i = 0; i < Registrazione.usersList.size(); i++) {
            nomeutente = Registrazione.usersList.get(i).getNomeU();
        }

        return nomeutente;
    }

}
