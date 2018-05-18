package com.aprendiz.ragp.strooper2.controllers;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooper2.R;
import com.aprendiz.ragp.strooper2.fragmets.Fragmentpalabra;

import java.util.TimerTask;

public class Juego extends AppCompatActivity {
    TextView txtcorrectas, txtincorrectas, txtintentos,txttiempo, txtaciertos;
    Button btncorrecta, btnincorrecta;
    TimerTask timerTask;
    int corretas, incorrectas, intentos;
    float aciertos;
    public static int ccorretas, cincorrectas, cintentos;
    public static double caciertos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        if (Fragmentpalabra.intentos>1){
            Fragmentpalabra.intentos=1;
        }
        inizialite();
        insertDatos();
        CountDownTimer countDownTimer = new CountDownTimer(30000,1) {
            int ss;
            int s;
            @Override
            public void onTick(long millisUntilFinished) {
                insertDatos();
                s= s+1;

            }

            @Override
            public void onFinish() {
                corretas=0;
                incorrectas=0;
                intentos=0;
                Fragmentpalabra.intentos=0;

                Intent intent = new Intent(Juego.this,Resumen.class);
                startActivity(intent);
                finish();
            }
        };
        countDownTimer.start();


        btncorrecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                truePalabra();
                intentos=Fragmentpalabra.intentos;
                Fragmentpalabra.pararcontador(v);

            }
        });
        btnincorrecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                falsePalabra();
                intentos=Fragmentpalabra.intentos;
                Fragmentpalabra.pararcontador(v);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentos=Fragmentpalabra.intentos;

    }

    public void insertDatos(){
        intentos = Fragmentpalabra.intentos;
        incorrectas = incorrectas + Fragmentpalabra.faltaincorrecta;
        txtcorrectas.setText("Correctas: "+corretas);
        txtincorrectas.setText("Incorrectas: "+incorrectas);
        txtintentos.setText("Intentos: "+intentos);
        txtaciertos.setText("Acierto: "+aciertos+"%");
        ccorretas=corretas;
        cincorrectas=incorrectas;
        cintentos= intentos;
        caciertos=aciertos;
        if (corretas>0) {
            double tmp1= corretas;
            double tmp2= intentos;
            float tmp= (float) (tmp1 / (tmp2-1));
            aciertos = (tmp*100);

        }else{
            aciertos=0;
        }


    }

    private void truePalabra() {
        int icj= Fragmentpalabra.icj;
        String tmpalabra= Fragmentpalabra.txtpalabra.getText().toString();
        String tmp2palabra= Fragmentpalabra.listPalabra.get(icj);
        if (tmpalabra.equals(tmp2palabra)){
            corretas=corretas+1;
        }else{
            incorrectas=incorrectas+1;
        }
    }

    private void falsePalabra() {
        int icj= Fragmentpalabra.icj;
        String tmpalabra= Fragmentpalabra.txtpalabra.getText().toString();
        String tmp2palabra= Fragmentpalabra.listPalabra.get(icj);
        if (!tmpalabra.equals(tmp2palabra)){
            corretas=corretas+1;
        }else{
            incorrectas=incorrectas+1;
        }
    }



    public void inizialite(){
        txtcorrectas = findViewById(R.id.txtcorrectas);
        txtincorrectas = findViewById(R.id.txtincorrectas);
        txtintentos = findViewById(R.id.txtintentos);
        txtaciertos=findViewById(R.id.txtaciertos);
        txttiempo = findViewById(R.id.txttiempo);
        btncorrecta = findViewById(R.id.btncorrecto);
        btnincorrecta = findViewById(R.id.btnincorrecto);

    }

}
