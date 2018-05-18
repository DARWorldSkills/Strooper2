package com.aprendiz.ragp.strooper2.controllers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooper2.R;
import com.aprendiz.ragp.strooper2.models.GestorDB;

import java.util.ArrayList;
import java.util.List;

public class Puntuacion extends AppCompatActivity {
    TextView txtprimero,txtsegundo,txttercero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        inizialite();
        inputPuesto();
    }

    private void inizialite() {
        txtprimero = findViewById(R.id.txtprimerlugar);
        txtsegundo = findViewById(R.id.txtsegundolugar);
        txttercero = findViewById(R.id.txttercerlugar);
    }

    public void inputPuesto() {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        List<String> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM DATOS ORDER BY PORCENTAJE DESC", null);
        if (cursor.moveToFirst()) {
            do {

                list.add("Correctos: "+cursor.getString(0)+" \nPorcentaje de Aciertos: "+cursor.getString(1));
            } while (cursor.moveToNext());
        }

        txtprimero.setText(list.get(0));
        txtsegundo.setText(list.get(1));
        txttercero.setText(list.get(2));

    }
}
