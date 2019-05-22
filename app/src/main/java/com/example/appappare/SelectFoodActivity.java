package com.example.appappare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectFoodActivity extends AppCompatActivity {

    private Button selezionaTutto;
    private Button avanti;
    private ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);

        avanti = (Button) findViewById(R.id.avanti);
        checkBoxes.add((CheckBox) findViewById(R.id.pesce));
        checkBoxes.add((CheckBox) findViewById(R.id.patatine));
        checkBoxes.add((CheckBox) findViewById(R.id.hamburger));
        checkBoxes.add((CheckBox) findViewById(R.id.kebab));
        checkBoxes.add((CheckBox) findViewById(R.id.frutta));
        checkBoxes.add((CheckBox) findViewById(R.id.panini));
        checkBoxes.add((CheckBox) findViewById(R.id.pizza));
        checkBoxes.add((CheckBox) findViewById(R.id.sushi));
        selezionaTutto = (Button) findViewById(R.id.selezionaTutto);
        selezionaTutto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAll(v);
            }
        });
    }

    private void selectAll(View view){
        for (int i = 0; i < checkBoxes.size(); i++) {
            CheckBox currentCheckBox = checkBoxes.get(i);
            currentCheckBox.setChecked(true);
        }
    }

    ArrayList<Integer> checkedPositions = new ArrayList<Integer>();

}
