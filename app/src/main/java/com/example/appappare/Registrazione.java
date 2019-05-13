package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registrazione extends AppCompatActivity {

    private EditText nuovoUsername;
    private EditText nuovaMail;
    private EditText nuovaPassword;
    private Button effettuaRegistrazione;
    private String nome, email, password;
    static ArrayList<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        nuovoUsername = (EditText) findViewById(R.id.nuovoUsername);
        nuovaMail= (EditText) findViewById(R.id.nuovaMail);
        nuovaPassword = (EditText) findViewById(R.id.nuovaPassword);
        effettuaRegistrazione = (Button) findViewById(R.id.effettuaRegistrazione);
        effettuaRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    public void register() {
        initialize();
        if (!validate()) {
            Toast.makeText(this, "Registrazione fallita",Toast.LENGTH_SHORT ).show();
        }else{
            onSignupSuccess();
        }
    }

    public void onSignupSuccess() {
        //TODO dopo input validazione
        usersList.add(new User(nome, email, password));
        log();
    }

    public void log() {
        Intent intent1 = new Intent(this, effettuaLogin.class);
        startActivity(intent1);
    }

    public boolean validate() {
        boolean valid = true ;
        if(nome.isEmpty() || nome.length()>32) {
            nuovoUsername.setError("Imserisci un nome valido");
            valid =  false;
        }
        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            nuovaMail.setError("Inserisci un indirizzo email valido");
            valid = false;
        }
        if(password.isEmpty() || password.length() < 8) {
            nuovaPassword.setError("La password deve essere lunga almeno 8 caratteri");
            valid = false;
        }

        return valid ;

    }

    public void initialize() {
        nome = nuovoUsername.getText().toString().trim();
        email = nuovaMail.getText().toString().trim();
        password = nuovaPassword.getText().toString().trim();


    }
}
