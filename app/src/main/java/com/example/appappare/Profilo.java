package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profilo extends AppCompatActivity {
    private ImageButton home;
    private Button salvate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        home = (ImageButton) findViewById(R.id.homeBtn);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

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

}
