package com.example.dolgozatsharedpreference;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button btnatlep,btnNevvalt,btninfo,btnKilep;
    private TextView tweredmeny;
    private AlertDialog alertDialog,alertDialog2;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);
        String seged = "";
        seged = sharedPreferences.getString("nev","Nincs elmentve a neved!");

        tweredmeny.setText(seged);


        btnatlep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
                finish();
            }
        });

        btnNevvalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(Main2Activity.this,"Név megváltozatva",Toast.LENGTH_SHORT).show();
            }
        });
        
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "A neved: "+tweredmeny.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnKilep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartActivity();
                alertDialog2.show();

                alertDialog.show();



            }
        });



    }

    public void init() {
        btnatlep = findViewById(R.id.btnAtlepes);
        btnNevvalt = findViewById(R.id.btnNevValt);
        btninfo = findViewById(R.id.btnInfo);
        btnKilep = findViewById(R.id.btnKilep);
        tweredmeny = findViewById(R.id.twEredmeny);

        alertDialogBuilder = new AlertDialog.Builder(Main2Activity.this);
        alertDialogBuilder.setMessage("Ki akarsz lépni az alkalmazásból?");
        alertDialogBuilder.setPositiveButton("Folytatom", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNegativeButton("Kilépés", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialog = alertDialogBuilder.create();
    }

    public void restartActivity(){
        alertDialogBuilder = new AlertDialog.Builder(Main2Activity.this);
        alertDialogBuilder.setMessage("Üdvözöljük újra "+tweredmeny.getText().toString());
        alertDialogBuilder.setPositiveButton("Folytatom", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNegativeButton("Új profil", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialog2 = alertDialogBuilder.create();
    }
}
