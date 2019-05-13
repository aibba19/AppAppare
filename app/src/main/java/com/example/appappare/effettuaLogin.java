package com.example.appappare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class effettuaLogin extends AppCompatActivity {
    private Button registratiButton;
    private EditText Username;
    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effettua_login);

        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.loginButton);
        registratiButton = (Button) findViewById(R.id.registratiButton);

        registratiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrazione();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });


    }

    public void validate(String user, String pass) {
        if((user.equals("Utente")) && (pass.equals("password"))) {
            Intent intent1 = new Intent(this, HomepageActivity.class);
            startActivity(intent1);
        }else{
            if((user.equals("")) && (pass.equals(""))) {
                AlertDialog.Builder vuoto = new AlertDialog.Builder(this);
                vuoto.setTitle("Campi vuoti");
                vuoto.setMessage("Riempi i campi di Username e Password!");
                AlertDialog alert = vuoto.create();
                alert.show();
            }else {
                AlertDialog.Builder errati = new AlertDialog.Builder(this);
                errati.setTitle("Credenziali errate");
                errati.setMessage("Reinserisci le tue credenziali!");
                AlertDialog alert1 = errati.create();
                alert1.show();
            }
        }
    }

    public void openRegistrazione() {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
}
 