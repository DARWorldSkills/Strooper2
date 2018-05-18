package com.aprendiz.ragp.strooper2.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aprendiz.ragp.strooper2.R;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    Button btnjugar, btnpuntaje,btnconfiguracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        inizialite();
        btnjugar.setOnClickListener(this);
        btnpuntaje.setOnClickListener(this);
        btnconfiguracion.setOnClickListener(this);

    }

    private void inizialite() {
        btnjugar = findViewById(R.id.btnjugar);
        btnpuntaje = findViewById(R.id.btnpuntaje);
        btnconfiguracion = findViewById(R.id.btnconfiguracion);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btnjugar:
                intent = new Intent(Menu.this,Juego.class);
                startActivity(intent);
                break;

            case R.id.btnpuntaje:
                intent = new Intent(Menu.this,Puntuacion.class);
                startActivity(intent);
                break;

            case R.id.btnconfiguracion:
                intent = new Intent(Menu.this,Configuracion.class);
                startActivity(intent);
                break;


        }

    }
}
