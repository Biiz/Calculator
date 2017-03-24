package com.example.michael.firstproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int op1 = -1;
    int op2 = -1;
    float result;
    char operation;

    ScrollView scrollResult;

    TextView onGoingOperation,
            risultato;

    Button bottonePiu,
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

        scrollResult = (ScrollView) findViewById(R.id.scrollResult);

        onGoingOperation = (TextView) findViewById((R.id.onGoingOperation));
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

        bottoneDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onGoingOperation.setText("");
                risultato.setText("");
                op1 = -1;
                op2 = -1;

                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bottone0:
                risultato.append("0");
                break;

            case R.id.bottone1:
                risultato.append("1");
                break;

            case R.id.bottone2:
                risultato.append("2");
                break;

            case R.id.bottone3:
                risultato.append("3");
                break;

            case R.id.bottone4:
                risultato.append("4");
                break;

            case R.id.bottone5:
                risultato.append("5");
                break;

            case R.id.bottone6:
                risultato.append("6");
                break;

            case R.id.bottone7:
                risultato.append("7");
                break;

            case R.id.bottone8:
                risultato.append("8");
                break;

            case R.id.bottone9:
                risultato.append("9");
                break;

            case R.id.bottonePiu:
                op1 = Integer.parseInt(risultato.getText().toString());
                risultato.setText("");
                onGoingOperation.append("\n" + op1 + "+");
                operation = '+';
                break;

            case R.id.bottoneMen:
                op1 = Integer.parseInt(risultato.getText().toString());
                risultato.setText("");
                onGoingOperation.append("\n" + op1 + "-");
                operation = '-';
                break;

            case R.id.bottonePer:
                op1 = Integer.parseInt(risultato.getText().toString());
                risultato.setText("");
                onGoingOperation.append("\n" + op1 + "*");
                operation = '*';
                break;

            case R.id.bottoneDiv:
                op1 = Integer.parseInt(risultato.getText().toString());
                risultato.setText("");
                onGoingOperation.append("\n" + op1 + "/");
                operation = '/';
                break;

            case R.id.bottoneDel:
                risultato.setText("");
                break;

            case R.id.bottoneUgu:
                if (op1 == -1) {
                    setToast("EH VOLEVII");
                    break;
                }
                op2 = Integer.parseInt(risultato.getText().toString());
                risultato.setText("");
                onGoingOperation.append("" + op2);
                switch (operation) {

                    case '+':
                        result = op1 + op2;
                        onGoingOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    case '-':
                        result = op1 - op2;
                        onGoingOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    case '*':
                        result = op1 * op2;
                        onGoingOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    case '/':
                        if (op2 == 0 && op1 == 0) {
                            setToast("Nope");
                            bottoneDel.performLongClick();
                            break;
                        }
                        result = op1 / (float) op2;
                        onGoingOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    default:
                        break;

                }
                scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                break;

            default:
                break;
        }
    }

    //create a toast getting a message input
    public void setToast(String message) {
        Context context = getApplicationContext();
        CharSequence text = "" + message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
