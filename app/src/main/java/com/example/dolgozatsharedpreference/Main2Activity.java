package com.example.dolgozatsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button btnatlep,btnNevvalt,btninfo,btnKilep;
    private TextView tweredmeny;

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
    }

    public void init(){
        btnatlep=findViewById(R.id.btnAtlepes);
        btnNevvalt=findViewById(R.id.btnNevValt);
        btninfo=findViewById(R.id.btnInfo);
        btnKilep=findViewById(R.id.btnKilep);
        tweredmeny=findViewById(R.id.twEredmeny);
    }
}
