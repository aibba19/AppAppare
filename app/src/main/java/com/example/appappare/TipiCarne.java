package com.example.appappare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class TipiCarne extends AppCompatActivity implements View.OnClickListener {
    private CheckBox bisteccaManzo,bisteccaCavallo,bisteccaMaiale,spezzatinoAsino,salsiccia,spiedini,costineMaiale,grigliataMista;
    //CREO BOTTONE
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipi_carne);
        bisteccaManzo=findViewById(R.id.bisteccaManzo);
        bisteccaCavallo=findViewById(R.id.bisteccaCavallo);
        bisteccaMaiale=findViewById(R.id.bisteccaMaiale);
        spezzatinoAsino=findViewById(R.id.spezzatinoAsino);
        salsiccia=findViewById(R.id.salsiccia);
        spiedini=findViewById(R.id.spiedini);
        costineMaiale=findViewById(R.id.costineMaiale);
        grigliataMista=findViewById(R.id.grigliataMista);

        bisteccaManzo.setOnClickListener(this);
        bisteccaCavallo.setOnClickListener(this);
        bisteccaMaiale.setOnClickListener(this);
        spezzatinoAsino.setOnClickListener(this);
        salsiccia.setOnClickListener(this);
        spiedini.setOnClickListener(this);
        costineMaiale.setOnClickListener(this);
        grigliataMista.setOnClickListener(this);

        //BOTTONE
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
    }
    //BOTTONE Apertura nuova pagina
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View view){
        if (view.getId()==R.id.bisteccaManzo){
            if (bisteccaManzo.isChecked()){
                Toast.makeText(getApplicationContext(), "bisteccaManzo è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.bisteccaCavallo){
            if (bisteccaCavallo.isChecked()){
                Toast.makeText(getApplicationContext(), "bisteccaCavallo è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.bisteccaMaiale){
            if (bisteccaMaiale.isChecked()){
                Toast.makeText(getApplicationContext(), "bisteccaMaiale è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.spezzatinoAsino){
            if (spezzatinoAsino.isChecked()){
                Toast.makeText(getApplicationContext(), "spezzatinoAsino è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.salsiccia){
            if (salsiccia.isChecked()){
                Toast.makeText(getApplicationContext(), "salsiccia è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.spiedini){
            if (spiedini.isChecked()){
                Toast.makeText(getApplicationContext(), "spiedini è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.costineMaiale){
            if (costineMaiale.isChecked()){
                Toast.makeText(getApplicationContext(), "costineMaiale è selezionato", Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId()==R.id.grigliataMista){
            if (grigliataMista.isChecked()){
                Toast.makeText(getApplicationContext(), "grigliataMista è selezionato", Toast.LENGTH_SHORT).show();
            }
        }


    }

}


