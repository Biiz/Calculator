package com.example.michael.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

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
        bottone0.setOnClickListener(this);
        bottone1 = (Button) findViewById(R.id.bottone1);
        bottone1.setOnClickListener(this);
        bottone2 = (Button) findViewById(R.id.bottone2);
        bottone2.setOnClickListener(this);
        bottone3 = (Button) findViewById(R.id.bottone3);
        bottone3.setOnClickListener(this);
        bottone4 = (Button) findViewById(R.id.bottone4);
        bottone4.setOnClickListener(this);
        bottone5 = (Button) findViewById(R.id.bottone5);
        bottone5.setOnClickListener(this);
        bottone6 = (Button) findViewById(R.id.bottone6);
        bottone6.setOnClickListener(this);
        bottone7 = (Button) findViewById(R.id.bottone7);
        bottone7.setOnClickListener(this);
        bottone8 = (Button) findViewById(R.id.bottone8);
        bottone8.setOnClickListener(this);
        bottone9 = (Button) findViewById(R.id.bottone9);
        bottone9.setOnClickListener(this);

        bottonePiu = (Button) findViewById(R.id.bottonePiu);
        bottonePiu.setOnClickListener(this);
        bottoneMen = (Button) findViewById(R.id.bottoneMen);
        bottoneMen.setOnClickListener(this);
        bottoneDiv = (Button) findViewById(R.id.bottoneDiv);
        bottoneDiv.setOnClickListener(this);
        bottonePer = (Button) findViewById(R.id.bottonePer);
        bottonePer.setOnClickListener(this);
        bottoneUgu = (Button) findViewById(R.id.bottoneUgu);
        bottoneUgu.setOnClickListener(this);
        bottoneDel = (Button) findViewById(R.id.bottoneDel);
        bottoneDel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bottone0:
                risultato.append("0");
                original_operation.add("0");
                break;

            case R.id.bottone1:
                risultato.append("1");
                original_operation.add("1");
                break;

            case R.id.bottone2:
                risultato.append("2");
                original_operation.add("2");
                break;

            case R.id.bottone3:
                risultato.append("3");
                original_operation.add("3");
                break;

            case R.id.bottone4:
                risultato.append("4");
                original_operation.add("4");
                break;

            case R.id.bottone5:
                risultato.append("5");
                original_operation.add("5");
                break;

            case R.id.bottone6:
                risultato.append("6");
                original_operation.add("6");
                break;

            case R.id.bottone7:
                risultato.append("7");
                original_operation.add("7");
                break;

            case R.id.bottone8:
                risultato.append("8");
                original_operation.add("8");
                break;

            case R.id.bottone9:
                risultato.append("9");
                original_operation.add("9");
                break;

            case R.id.bottonePiu:
                risultato.append(" +");
                original_operation.add("+");
                break;

            case R.id.bottoneMen:
                risultato.append(" -");
                original_operation.add("-");
                break;
            case R.id.bottonePer:
                risultato.append(" *");
                original_operation.add("*");
                break;

            case R.id.bottoneDiv:
                risultato.append(" /");
                original_operation.add("/");
                break;

            case R.id.bottoneDel:
                Log.v(getPackageName(), "Del HIT");
                risultato.setText("");
                original_operation.clear();
                break;

            case R.id.bottoneUgu:
                for(int i=0; i<original_operation.size(); i++){
                    Log.v(getPackageName(),original_operation.get(i).toString());
                    if(Character.isDigit(original_operation.get(i).charAt(0))) {
                        Log.v(getPackageName(), "digit founded");
                    }
                }
                risultato.setText(""+parseOperation(original_operation));
                break;

            default:
                break;
        }
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
