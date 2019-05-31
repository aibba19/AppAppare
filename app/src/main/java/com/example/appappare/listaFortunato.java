package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listaFortunato extends AppCompatActivity {

    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;

    ListView lista;
    String titoli[] = {"Du fritture", "Cesarina", "Menu Hamburger"};
    String descrizioni[] = {"Frittura mista", "Caesar Salad", "Hamburger, patatine, bibita 33cl"};
    String prezzi[] = {"10€", "7€", "5€"};
    String scadenze[] = {"08/07/2019" , "05/11/2019" , "05/09/2019"};
    String locali[] = {"O' mare (800 m)", "Il foro (780 m)" , "Country Smokehouse (650 m)"};
    int foto[] = {R.drawable.frittura, R.drawable.caesar_salad, R.drawable.hamburgeroffertafortunata};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_fortunato);

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

        lista = (ListView) findViewById(R.id.listaAffamato);

        listaFortunato.CustomAdapter customAdapter = new listaFortunato.CustomAdapter();
        lista.setAdapter(customAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),OffertaFortunato.class);
                intent.putExtra("nome", titoli[position]);
                intent.putExtra("locale", locali[position]);
                intent.putExtra("descrizione", descrizioni[position]);
                intent.putExtra("foto", foto[position]);
                intent.putExtra("prezzo", prezzi[position]);
                intent.putExtra("scadenza", scadenze[position]);
                startActivity(intent);

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
        Intent indietro = new Intent(this, HomepageActivity.class);
        startActivity(indietro);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return foto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View affamato = getLayoutInflater().inflate(R.layout.riga_affamato, null);

            TextView name = affamato.findViewById(R.id.titoloAffamato);
            TextView place = affamato.findViewById(R.id.localeAffamato);
            TextView description = affamato.findViewById(R.id.descrizioneAffamato);
            TextView cost = affamato.findViewById(R.id.prezzoAffamato);
            TextView scad = affamato.findViewById(R.id.scadenzaAffamato);
            ImageView photo = affamato.findViewById(R.id.fotofoodAffamato);

            name.setText(titoli[position]);
            place.setText(locali[position]);
            description.setText(descrizioni[position]);
            cost.setText(prezzi[position]);
            scad.setText(scadenze[position]);
            photo.setImageResource(foto[position]);

            return affamato;
        }
    }
}
