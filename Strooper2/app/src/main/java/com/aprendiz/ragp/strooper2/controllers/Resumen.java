package com.aprendiz.ragp.strooper2.controllers;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooper2.R;
import com.aprendiz.ragp.strooper2.fragmets.Fragmentpalabra;
import com.aprendiz.ragp.strooper2.models.GestorDB;

public class Resumen extends AppCompatActivity {
    TextView txtcorrectas, txtincorrectas, txttiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        inizialite();
        inputtext();
        inputdatabase();
    }

    private void inizialite() {
        txtcorrectas = findViewById(R.id.txtpalabrasCorr);
        txtincorrectas = findViewById(R.id.txtpalabrasIncorr);
        txttiempo = findViewById(R.id.txttiempoRea);
    }

    public void inputtext(){
        txtcorrectas.setText(Double.toString(Juego.ccorretas));
        txtincorrectas.setText(Double.toString(Juego.cincorrectas));

    }

    public void inputdatabase(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("ACIERTOS",Juego.ccorretas);
            values.put("PORCENTAJE",Juego.caciertos);
            db.insert("DATOS",null,values);
            Juego.ccorretas=0;
            Juego.caciertos=0;
            Fragmentpalabra.intentos=0;
        }catch (Exception e){
            Toast.makeText(this, "Algo anda mal :(", Toast.LENGTH_SHORT).show();
        }
    }


    public void volver(View view) {
        Intent intent = new Intent(Resumen.this,Menu.class);
        startActivity(intent);
        finish();

    }
}
