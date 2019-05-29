package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class Ingredienti extends AppCompatActivity implements View.OnClickListener {

    private CheckBox salame,wurstel,cotto,patate,funghi,pomodorini,rucola,pancetta;
    private Button button;
    private ImageButton home;
    private ImageButton profilo;
    private ImageButton indietro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredienti);
        salame=findViewById(R.id.salame);
        wurstel=findViewById(R.id.wurstel);
        cotto=findViewById(R.id.cotto);
        patate=findViewById(R.id.patate);
        funghi=findViewById(R.id.funghi);
        pomodorini=findViewById(R.id.pomodorini);
        rucola=findViewById(R.id.rucola);
        pancetta=findViewById(R.id.pancetta);

        salame.setOnClickListener(this);
        wurstel.setOnClickListener(this);
        cotto.setOnClickListener(this);
        patate.setOnClickListener(this);
        funghi.setOnClickListener(this);
        pomodorini.setOnClickListener(this);
        rucola.setOnClickListener(this);
        pancetta.setOnClickListener(this);

        button = findViewById(R.id.procedi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProcedi();

            }
        });

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
    }

    @Override
    public void onClick(View view){
        if (view.getId()==R.id.salame){
            if (salame.isChecked()){
                Toast.makeText(getApplicationContext(), "salame è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.wurstel){
            if (wurstel.isChecked()){
                Toast.makeText(getApplicationContext(), "wurstel è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.cotto){
            if (cotto.isChecked()){
                Toast.makeText(getApplicationContext(), "prosciutto cotto è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.patate){
            if (patate.isChecked()){
                Toast.makeText(getApplicationContext(), "patate fritte è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.funghi){
            if (funghi.isChecked()){
                Toast.makeText(getApplicationContext(), "funghi è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.pomodorini){
            if (pomodorini.isChecked()){
                Toast.makeText(getApplicationContext(), "pomodorini è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.rucola){
            if (rucola.isChecked()){
                Toast.makeText(getApplicationContext(), "rucola è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.pancetta){
            if (pancetta.isChecked()){
                Toast.makeText(getApplicationContext(), "pancetta è selezionato", Toast.LENGTH_SHORT).show();
            }
        }


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
        Intent indietro = new Intent(this, SelectFoodActivity.class);
        startActivity(indietro);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void goProcedi() {
        Intent procedi = new Intent(this, Distanza.class);
        startActivity(procedi);
    }

}
