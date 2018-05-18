package com.aprendiz.ragp.strooper2.fragmets;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.aprendiz.ragp.strooper2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmentpalabra#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmentpalabra extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static TextView txtpalabra;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static int intentos;
    public static int faltaincorrecta=0;
    public static CountDownTimer cambio;
    public static int icj,ipj;
    public static List<String> listPalabra = new ArrayList<>();
    public static List<Integer> listColor = new ArrayList<>();


    public Fragmentpalabra() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmentpalabra.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmentpalabra newInstance(String param1, String param2) {
        Fragmentpalabra fragment = new Fragmentpalabra();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragmentpalabra, container, false);
        reinicio();
        inizialite(v);
        randompalabra();

        return v;
    }

    private static void randompalabra() {

        ipj = (int) (Math.random()*6)+1;
        icj = (int) (Math.random()*6)+1;

        txtpalabra.setText(listPalabra.get(ipj));
        txtpalabra.setTextColor(listColor.get(icj));

    }

    private void inizialite(View v) {
        txtpalabra= v.findViewById(R.id.txtpalabra);
        listar();
    }


    public static void reinicio(){
        intentos=intentos+1;
        cambio = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                randompalabra();
                reinicio();

            }
        }.start();
    }

    public static void pararcontador(View v) {
        cambio.cancel();
        cambio.start();
        intentos=intentos+1;
        randompalabra();

    }

    private void listar() {
        listPalabra.add(0,"AMARILLO");
        listColor.add(0,getResources().getColor(R.color.colorAmarilloj));

        listPalabra.add(1,"AMARILLO");
        listColor.add(1,getResources().getColor(R.color.colorAmarilloj));

        listPalabra.add(2,"AZUL");
        listColor.add(2,getResources().getColor(R.color.colorAzulj));

        listPalabra.add(3,"NARANJA");
        listColor.add(3,getResources().getColor(R.color.colorNaranjaj));

        listPalabra.add(4,"BLANCO");
        listColor.add(4,getResources().getColor(R.color.colorBlancoj));

        listPalabra.add(5,"ROJO");
        listColor.add(5,getResources().getColor(R.color.colorRojoj));

        listPalabra.add(6,"VERDE");
        listColor.add(6,getResources().getColor(R.color.colorVerdej));

        listPalabra.add(7,"PURPURA");
        listColor.add(7,getResources().getColor(R.color.colorPurpuraj));

    }



}
