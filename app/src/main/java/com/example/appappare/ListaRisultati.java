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

public class ListaRisultati extends AppCompatActivity {

    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;

    ListView lista;
    String titoli[] = {"L'americana", "Pizza Wurstel", "Pizza patatine"};
    String descrizioni[] = {"Pizza wurstel e patatine", "Pizza Wurstel", "Pizza patatine fritte"};
    String prezzi[] = {"4.5€", "4€", "4€"};
    String scadenze[] = {"03/07/2019" , "05/09/2019" , "15/08/2019"};
    String locali[] = {"King Pizza (475 m)", "Il forno (250 m)" , "Vesuvio (350 m)"};
    int foto[] = {R.drawable.americana, R.drawable.wurstel, R.drawable.patatine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_risultati);

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

        ListaRisultati.CustomAdapter customAdapter = new ListaRisultati.CustomAdapter();
        lista.setAdapter(customAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),VisualizzaOfferta.class);
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
        Intent indietro = new Intent(this, Distanza.class);
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
            TextView description = view1.findViewById(R.id.descrizioneOfferta);
            TextView cost = view1.findViewById(R.id.prezzoOfferta);
            TextView scad = view1.findViewById(R.id.scadenzaOfferta);
            ImageView photo = view1.findViewById(R.id.fotofood);

            name.setText(titoli[position]);
            place.setText(locali[position]);
            description.setText(descrizioni[position]);
            cost.setText(prezzi[position]);
            scad.setText(scadenze[position]);
            photo.setImageResource(foto[position]);

            return view1;
        }
    }
}
