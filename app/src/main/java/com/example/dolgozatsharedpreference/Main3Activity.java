package com.example.dolgozatsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private Button btnvissza;
    private TextView felirat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        btnvissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init()
    {
        felirat=findViewById(R.id.twFelirat);
        btnvissza=findViewById(R.id.btnVissza);
    }
}
