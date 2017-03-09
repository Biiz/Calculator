package com.example.michael.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.Context;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText numero;
    TextView risultato;
    Button bottonePiu;
    Button bottoneUguale;
    Button bottoneDiviso;
    Button bottonePer;
    Button bottoneMeno;
    double res;
    String operazione;

    ArrayList<Double> numeri;
    ArrayList<String> operazioni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeri = new ArrayList<Double>();
        operazioni = new ArrayList<String>();

        numero = (EditText) findViewById(R.id.numero);
        bottonePiu = (Button) findViewById(R.id.bottonePiu);
        bottoneMeno = (Button) findViewById(R.id.bottoneMeno);
        bottoneDiviso = (Button) findViewById(R.id.bottoneDiviso);
        bottonePer = (Button) findViewById(R.id.bottonePer);
        bottoneUguale = (Button) findViewById(R.id.bottoneUguale);
        risultato = (TextView) findViewById(R.id.risultato);


        bottonePiu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                operazione = "piu";
                checkNumber();
            }
        });

        bottoneMeno.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkNumber();
                operazione = "meno";
            }
        });

        bottoneDiviso.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkNumber();
                operazione="diviso";
            }
        });

        bottonePer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkNumber();
                operazione="per";
            }
        });

        bottoneUguale.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                if (checkResult()) {

                    for(int i = 0; i <= numeri.size(); i++){
                        if(i%2 == 0 && i != 0) {
                            switch (operazioni.get(i-2)) {
                                case "+": res += (numeri.get(i-2) + numeri.get(i-1));
                                    break;
                                case "-": res += (numeri.get(i-2) - numeri.get(i-1));
                                    break;
                                case "/": res += (numeri.get(i-2) / numeri.get(i-1));
                                    break;
                                case "*": res += (numeri.get(i-2) * numeri.get(i-1));
                                    break;
                            }
                        }

                        if(i%2 != 0 && i > 2) {
                            switch (operazioni.get(i-1)) {
                                case "+": res += numeri.get(i-1);
                                    break;
                                case "-": res -= numeri.get(i-1);
                                    break;
                                case "/": res = res / numeri.get(i-1);
                                    break;
                                case "*": res = res * numeri.get(i-1);
                                    break;
                            }
                        }

                    }

                    numero.setText("");
                    risultato.setText(""+res);
                    res = 0.0;
                }

            }
        });

    }

    private void checkNumber (){
        if(numero.getText().toString().isEmpty()){
            Context context = MainActivity.this;
            String textToShow = "Not a Number";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
            for(int i = 0; i < numeri.size(); i++) {
                numeri.set(i,0.0);
            }
            for(int i = 0; i < operazioni.size(); i++){
                operazioni.set(i, "");
            }
            res = 0.0;
            risultato.setText("");
        }else{
            numeri.add(Double.parseDouble(numero.getText().toString()));
            switch (operazione) {
                case "piu": operazioni.add("+");
                    break;
                case "meno": operazioni.add("-");
                    break;
                case "diviso": operazioni.add("/");
                    break;
                case "per": operazioni.add("*");
                    break;
            }
            numero.setText("");
        }
    }

    private boolean checkResult (){
        boolean result;
        //se il numero è vuoto mostro un Toast
        if(numero.getText().toString().isEmpty()){
            Context context = MainActivity.this;
            String textToShow = "Not a Number";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
            //set l'array dei numeri a 0.0
            for(int i = 0; i < numeri.size(); i++) {
                numeri.set(i,0.0);
            }
            //set l'array delle operazioni a ""
            for(int i = 0; i < operazioni.size(); i++){
                operazioni.set(i, "");
            }
            res = 0.0;
            risultato.setText("");
            result = false;
        }
        //altrimenti aggiungo il numero nell'array dei numeri
        else{
            numeri.add(Double.parseDouble(numero.getText().toString()));
            result = true;
        }
        return result;
    }


}
