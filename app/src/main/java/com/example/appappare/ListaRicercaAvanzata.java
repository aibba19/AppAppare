package com.example.appappare;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class ListaRicercaAvanzata extends AppCompatActivity {
    ListView listView;

    String mTitle[] = {"pizzeria","pizzeria","pizzeria","paninoteca","paninoteca" };
    String mDescriptor[] = {"pizzeria description","pizzeria description","pizzeria description","paninoteca description","paninoteca description"};
    int images[] = {R.drawable.hamburger_pyramid , R.drawable.hamburger_pyramid , R.drawable.hamburger_pyramid , R.drawable.hamburger_pyramid , R.drawable.hamburger_pyramid};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ricerca_avanzata);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter( this, mTitle, mDescriptor, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(ListaRicercaAvanzata.this, "pizzeria description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListaRicercaAvanzata.this, "pizzeria description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListaRicercaAvanzata.this, "pizzeria description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListaRicercaAvanzata.this, "paninoteca description", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListaRicercaAvanzata.this, "paninoteca description", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
      class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        MyAdapter (Context c, String title[], String descriptor[], int imgs[]){
            super (c,R.layout.row, R.id.textView1, title);
            this.context=c;
            this.rTitle=title;
            this.rDescription=descriptor;
            this.rImgs=imgs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}
