package com.example.appappare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageButton;
import android.widget.Toast;

public class effettuaLogin extends AppCompatActivity {
    private Button registratiButton;
    private EditText Username;
    private EditText Password;
    private Button Login;
    private ImageButton Posizione;
    private boolean gps = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effettua_login);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.loginButton);
        registratiButton = (Button) findViewById(R.id.registratiButton);

        Posizione = (ImageButton) findViewById(R.id.posizionebtn);
        Posizione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = !gps;

                if(gps) {
                    posizione();
                    Posizione.setBackgroundResource(R.drawable.outline_room_black_48dp);
                } else {
                    noPos();
                    Posizione.setBackgroundResource(R.drawable.outline_room_white_48dp);
                }

            }
        });

        registratiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrazione();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gps) {
                    validate(Username.getText().toString(), Password.getText().toString());

                } else {
                    attivagps();
                }

            }
        });


    }
    //TODO va cambiato perchè deve prendere gli utenti dalla lista
    /*if((user.equals("Utente")) && (pass.equals("password"))) {
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
        }*/
    public void validate(String user, String pass) {
        for (int i = 0; i < Registrazione.usersList.size(); i++) {
            if((user.equals(Registrazione.usersList.get(i).getNomeU())) &&
                    pass.equals(Registrazione.usersList.get(i).getPasswordU())){
                Intent intent1 = new Intent(this, HomepageActivity.class);
                startActivity(intent1);
            } else {
                if((user.equals("")) && (pass.equals(""))) {
                    AlertDialog.Builder vuoto = new AlertDialog.Builder(this);
                    vuoto.setTitle("Campi vuoti");
                    vuoto.setMessage("Riempi i campi di Username e Password!");
                    AlertDialog alert = vuoto.create();
                    alert.show();
                }else {
                    AlertDialog.Builder errati = new AlertDialog.Builder(this);
                    errati.setTitle("Credenziali errate");
                    errati.setMessage("Reinserisci le tue credenziali o registrati!");
                    AlertDialog alert1 = errati.create();
                    alert1.show();
                }
            }
        }
    }

    public void openRegistrazione() {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }

    public void posizione() {
        Context context = getApplicationContext();
        CharSequence text = "Geolocalizzazione attivata";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public void noPos() {
        Context context = getApplicationContext();
        CharSequence text = "Geolocalizzazione disattivata";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public void attivagps() {
        Context context = getApplicationContext();
        CharSequence text = "Attiva la geolocalizzazione per andare avanti!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

}
 