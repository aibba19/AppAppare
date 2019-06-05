package com.example.appappare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectFoodActivity extends AppCompatActivity {

    private Button selezionaTutto;
    private Button avanti;
    private CheckBox carne;
    private CheckBox pizza;
    private boolean checkCarne = false;
    private boolean checkPizza = false;
    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;

  //  private ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);

        carne = findViewById(R.id.carne);
        pizza = findViewById(R.id.pizza);
        avanti = findViewById(R.id.avanti);

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


        carne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCarne = carne.isChecked();
            }
        });

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPizza = pizza.isChecked();
            }
        });


        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkCarne){
                    startActivity(new Intent(SelectFoodActivity.this, TipiCarne.class));
                    scegliCarne();
                }else {
                    startActivity(new Intent(SelectFoodActivity.this, Distanza.class));
                }
                if(checkPizza){
                    startActivity(new Intent(SelectFoodActivity.this, Ingredienti.class));
                    scegliPizza();
                    }else {
                    startActivity(new Intent(SelectFoodActivity.this, Distanza.class));
                }
            }
        });
    }


    public void scegliCarne() {
        Context context = getApplicationContext();
        CharSequence text = "Scegli il tipo di carne!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public void scegliPizza() {
        Context context = getApplicationContext();
        CharSequence text = "Scegli gli ingredienti per la tua pizza!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
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


}
