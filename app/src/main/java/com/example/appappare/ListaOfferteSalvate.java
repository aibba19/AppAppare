package com.example.appappare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;


public class ListaOfferteSalvate extends AppCompatActivity {
    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;

    ListView lista;
    String titoli[] = {"L'americana", "Menu Hamburger", "Grill 'em all"};
    String descrizioni[] = {"Pizza wurstel e patatine", "Hamburger, patatine, bibita 33cl", "Bistecca di manzo, contorno, bibita"};
    String prezzi[] = {"3.5€", "5€", "13€"};
    String scadenze[] = {"03/07/2019" , "05/09/2019" , "15/08/2019"};
    String locali[] = {"King Pizza", "Il Panino Buono" , "Country Smokehouse"};
    String distanze[] = {"475 m", "350 m", "650 m"};
    int foto[] = {R.drawable.americana, R.drawable.hamburgerofferta, R.drawable.bisteccaofferte};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_offerte_salvate);

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

        lista = (ListView) findViewById(R.id.listaOfferteSalvate);

        CustomAdapter customAdapter = new CustomAdapter();
        lista.setAdapter(customAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),offertaSalvata.class);
                intent.putExtra("nome", titoli[position]);
                intent.putExtra("locale", locali[position]);
                intent.putExtra("distanza", distanze[position]);
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
        Intent indietro = new Intent(this, Profilo.class);
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
            View view1 = getLayoutInflater().inflate(R.layout.riga_lista_salvati, null);

            TextView name = view1.findViewById(R.id.TitoloOfferta);
            TextView place = view1.findViewById(R.id.nomeLocale);
            TextView distance = view1.findViewById(R.id.distanzaOfferta);
            TextView description = view1.findViewById(R.id.descrizioneOfferta);
            TextView cost = view1.findViewById(R.id.prezzoOfferta);
            TextView scad = view1.findViewById(R.id.scadenzaOfferta);
            ImageView photo = view1.findViewById(R.id.fotofood);

            name.setText(titoli[position]);
            place.setText(locali[position]);
            distance.setText(distanze[position]);
            description.setText(descrizioni[position]);
            cost.setText(prezzi[position]);
            scad.setText(scadenze[position]);
            photo.setImageResource(foto[position]);

            return view1;
        }
    }



    /*class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myTitles[];
        String myDescriptions[];
        int[] fotos;

        MyAdapter(Context c, String[] titoli, int[] foto, String[] descrizioni) {
            super(c, R.layout.riga_lista_salvati, R.id.TitoloOfferta, titoli);
            this.context = c;
            this.fotos = foto;
            this.myDescriptions = descrizioni;
            this.myTitles = titoli;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View riga = layoutInflater.inflate(R.layout.riga_lista_salvati, parent, false);
            ImageView images = riga.findViewById(R.id.fotofood);
            TextView myTitle = riga.findViewById(R.id.TitoloOfferta);
            TextView myDescription = riga.findViewById(R.id.descrizioneOfferta);
            images.setImageResource(fotos[position]);
            myTitle.setText(titoli[position]);
            myDescription.setText(descrizioni[position]);
2
            return riga;
        }
    }*/



}
