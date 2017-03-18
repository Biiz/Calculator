package com.example.michael.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> original_operation;
    TextView risultato;

    Button  bottonePiu,
            bottoneMen,
            bottonePer,
            bottoneDiv,
            bottoneUgu,
            bottoneDel,
            bottone0,
            bottone1,
            bottone2,
            bottone3,
            bottone4,
            bottone5,
            bottone6,
            bottone7,
            bottone8,
            bottone9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        original_operation = new ArrayList<String>();

        risultato = (TextView) findViewById(R.id.risultato);

        bottone0 = (Button) findViewById(R.id.bottone0);
        bottone1 = (Button) findViewById(R.id.bottone1);
        bottone2 = (Button) findViewById(R.id.bottone2);
        bottone3 = (Button) findViewById(R.id.bottone3);
        bottone4 = (Button) findViewById(R.id.bottone4);
        bottone5 = (Button) findViewById(R.id.bottone5);
        bottone6 = (Button) findViewById(R.id.bottone6);
        bottone7 = (Button) findViewById(R.id.bottone7);
        bottone8 = (Button) findViewById(R.id.bottone8);
        bottone9 = (Button) findViewById(R.id.bottone9);

        bottonePiu = (Button) findViewById(R.id.bottonePiu);
        bottoneMen = (Button) findViewById(R.id.bottoneMeno);
        bottoneDiv = (Button) findViewById(R.id.bottoneDiviso);
        bottonePer = (Button) findViewById(R.id.bottonePer);
        bottoneUgu = (Button) findViewById(R.id.bottoneUguale);
        bottoneDel = (Button) findViewById(R.id.bottoneDel);
        bottonePiu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append(" +");
                original_operation.add("+");
            }
        });

        bottoneMen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append(" -");
                original_operation.add("-");
            }
        });

        bottoneDiv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append(" /");
                original_operation.add("/");
            }
        });

        bottonePer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append(" *");
                original_operation.add("*");
            }
        });

        bottone0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("0");
                original_operation.add("0");
            }
        });

        bottone1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("1");
                original_operation.add("1");
            }
        });

        bottone2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("2");
                original_operation.add("2");
            }
        });

        bottone3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("3");
                original_operation.add("3");
            }
        });

        bottone4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("4");
                original_operation.add("4");
            }
        });

        bottone5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("5");
                original_operation.add("5");
            }
        });

        bottone6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("6");
                original_operation.add("6");
            }
        });

        bottone7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("7");
                original_operation.add("7");
            }
        });

        bottone8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("8");
                original_operation.add("8");
            }
        });

        bottone9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                risultato.append("9");
                original_operation.add("9");
            }
        });

        bottoneUgu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                for(int i=0; i<original_operation.size(); i++){
                    Log.v(getPackageName(),original_operation.get(i).toString());
                    if(Character.isDigit(original_operation.get(i).charAt(0))) {
                        Log.v(getPackageName(), "digit founded");
                    }
                }
                risultato.setText(""+parseOperation(original_operation));
            }
        });
        bottoneDel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(getPackageName(), "Del HIT");
                risultato.setText("");
                original_operation.clear();

            }
        });

    }

    public float parseOperation(ArrayList<String> input){
        ArrayList<String> parsed_operation = new ArrayList<String>();
        //indice per gestire l'ArrayList
        int index=0;
        for(int i = 0; i< input.size(); i++){

            if(Character.isDigit(input.get(i).charAt(0))){
                parsed_operation.add(index, ""+ input.get(i));
                Log.v(getPackageName(), "found digit: "+ input.get(i));
            }else{
                if(i!=0) {
                    Log.v(getPackageName(), "before ++index, index= "+index);
                    ++index;
                    Log.v(getPackageName(), "after ++index, index= "+index);
                    switch (input.get(i)) {
                        case "+":
                            Log.v(getPackageName(), "found operand: +");
                            parsed_operation.add(index, "+");
                            break;
                        case "-":
                            parsed_operation.add(index, "-");
                            break;
                        case "*":
                            parsed_operation.add(index, "*");
                            break;
                        case "/":
                            parsed_operation.add(index, "/");
                            break;
                    }
                    ++index;
                }
            }
        }
        Log.v(getPackageName(), "pos 0: "+parsed_operation.get(0));
        Log.v(getPackageName(), "pos 1: "+parsed_operation.get(1));
        Log.v(getPackageName(), "pos 2: "+parsed_operation.get(2));
        return execOperation(parsed_operation);

    }

    public float execOperation(ArrayList<String> arLiStr){

        int opr1, opr2;
        float result = 0;
        if (arLiStr.size() < 2) {
            Log.v(getPackageName(), "size error");
            return 0;
        }

        Log.v(getPackageName(), "pos 0: "+arLiStr.get(0));
        Log.v(getPackageName(), "pos 1: "+arLiStr.get(1));
        Log.v(getPackageName(), "pos 2: "+arLiStr.get(2));

        //for(int i=0; i<arLiStr.size()-1; i++){
            opr1 = Integer.parseInt((arLiStr.get(0)));
            opr2 = Integer.parseInt((arLiStr.get(2)));
            Log.v(getPackageName(), "before switch");
            switch (original_operation.get(1)) {
                case "+":
                    Log.v(getPackageName(), "adding operation");
                    result = opr1 + opr2;
                    break;
                case "-":
                    result = opr1 - opr2;
                    break;
                case "*":
                    result = opr1 * opr2;
                    break;
                case "/":
                    result = opr1 / opr2;
                    break;
            }
        //}
        return result;
    }


}
