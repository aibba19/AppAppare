package com.example.appappare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VisualizzaOfferta extends AppCompatActivity {

    TextView nome;
    TextView locale;
    TextView contenuto;
    ImageView foto;
    TextView prezzo;
    TextView scadenza;
    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;
    private ImageButton salva;
    private boolean clicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_offerta);

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

        salva = (ImageButton) findViewById(R.id.saveBtn);
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = !clicked;

                if(clicked) {
                    saved();
                    salva.setBackgroundResource(R.drawable.outline_bookmark_black_48dp);
                } else {
                    removed();
                    salva.setBackgroundResource(R.drawable.outline_bookmark_white_48dp);
                }

            }
        });

        nome = findViewById(R.id.nomeOfferta);
        contenuto = findViewById(R.id.contenutoOfferta);
        prezzo=findViewById(R.id.costoOfferta);
        foto = findViewById(R.id.fotoOfferta);
        locale = findViewById(R.id.locale);
        scadenza = findViewById(R.id.scadenza);
        Intent intent = getIntent();

        nome.setText(intent.getStringExtra("nome"));
        locale.setText(intent.getStringExtra("locale"));
        contenuto.setText(intent.getStringExtra("descrizione"));
        prezzo.setText(intent.getStringExtra("prezzo"));
        scadenza.setText(intent.getStringExtra("scadenza"));
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
        Intent indietro = new Intent(this, ListaRisultati.class);
        startActivity(indietro);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void saved() {
        Context context = getApplicationContext();
        CharSequence text = "Offerta Salvata!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }


    public void removed() {
        Context context = getApplicationContext();
        CharSequence text = "Elemento rimosso dagli oggetti salvati";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
