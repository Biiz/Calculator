package com.example.michael.firstproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int counterTextSize = 0;
    int op1 = -1;
    int op2 = -1;
    float result;
    char operation;
    boolean flagResult = false;

    ScrollView scrollResult;

    TextView operationHistory,
            currentNumber,
            currentOperation;

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
        setContentView(R.layout.activity_second);

        scrollResult = (ScrollView) findViewById(R.id.scrollResult);

        operationHistory = (TextView) findViewById((R.id.operationHistory));
        currentNumber = (TextView) findViewById(R.id.currentNumber);
        currentOperation = (TextView) findViewById(R.id.currentOperation);

        currentOperation.setOnClickListener(this);

        bottone0 = (Button) findViewById(R.id.numPad0);
        bottone0.setOnClickListener(this);
        bottone1 = (Button) findViewById(R.id.numPad1);
        bottone1.setOnClickListener(this);
        bottone2 = (Button) findViewById(R.id.numPad2);
        bottone2.setOnClickListener(this);
        bottone3 = (Button) findViewById(R.id.numPad3);
        bottone3.setOnClickListener(this);
        bottone4 = (Button) findViewById(R.id.numPad4);
        bottone4.setOnClickListener(this);
        bottone5 = (Button) findViewById(R.id.numPad5);
        bottone5.setOnClickListener(this);
        bottone6 = (Button) findViewById(R.id.numPad6);
        bottone6.setOnClickListener(this);
        bottone7 = (Button) findViewById(R.id.numPad7);
        bottone7.setOnClickListener(this);
        bottone8 = (Button) findViewById(R.id.numPad8);
        bottone8.setOnClickListener(this);
        bottone9 = (Button) findViewById(R.id.numPad9);
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
                operationHistory.setText("");
                currentNumber.setText("");
                currentOperation.setText("");
                op1 = -1;
                op2 = -1;
                enableOperationButton(false);
                return true;
            }
        });

        enableOperationButton(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.currentOperation:
                if(flagResult == true) checkCurrentOperation();
                break;

            case R.id.numPad0:
                numPadFunction("0");

                break;

            case R.id.numPad1:
                numPadFunction("1");
                break;

            case R.id.numPad2:
                numPadFunction("2");
                break;

            case R.id.numPad3:
                numPadFunction("3");
                break;

            case R.id.numPad4:
                numPadFunction("4");
                break;

            case R.id.numPad5:
                numPadFunction("5");
                break;

            case R.id.numPad6:
                numPadFunction("6");
                break;

            case R.id.numPad7:
                numPadFunction("7");
                break;

            case R.id.numPad8:
                numPadFunction("8");
                break;

            case R.id.numPad9:
                numPadFunction("9");
                break;

            case R.id.bottonePiu:
                op1 = Integer.parseInt(currentNumber.getText().toString());
                currentNumber.setText("");
                currentOperation.append(op1 + "+");
                operation = '+';
                enableOperationButton(false);
                break;

            case R.id.bottoneMen:
                op1 = Integer.parseInt(currentNumber.getText().toString());
                currentNumber.setText("");
                currentOperation.append(op1 + "-");
                operation = '-';
                enableOperationButton(false);
                break;

            case R.id.bottonePer:
                op1 = Integer.parseInt(currentNumber.getText().toString());
                currentNumber.setText("");
                currentOperation.append(op1 + "*");
                operation = '*';
                enableOperationButton(false);
                break;

            case R.id.bottoneDiv:
                op1 = Integer.parseInt(currentNumber.getText().toString());
                currentNumber.setText("");
                currentOperation.append(op1 + "/");
                operation = '/';
                enableOperationButton(false);
                break;

            case R.id.bottoneDel:
                currentNumber.setText("");
                break;

            case R.id.bottoneUgu:
                if (op1 == -1) {
                    setToast("EH VOLEVII");
                    enableOperationButton(false);
                    break;
                }
                op2 = Integer.parseInt(currentNumber.getText().toString());
                currentNumber.setText("");
                currentOperation.append("" + op2);
                switch (operation) {

                    case '+':
                        result = op1 + op2;
                        currentOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    case '-':
                        result = op1 - op2;
                        currentOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    case '*':
                        result = op1 * op2;
                        currentOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    case '/':
                        if (op2 == 0 && op1 == 0) {
                            setToast("Nope");
                            bottoneDel.performLongClick();
                            break;
                        }
                        result = op1 / (float) op2;
                        currentOperation.append(" = " + result);
                        scrollResult.fullScroll(ScrollView.FOCUS_DOWN);
                        break;

                    default:
                        break;

                }
                flagResult = true;
                enableOperationButton(false);
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

    /*
        Funzione invocata quando un bottone numPad è premuto
     */
    public void numPadFunction(String buttonValue){
        if (flagResult == true) checkCurrentOperation();
        currentNumber.append(buttonValue);
        enableOperationButton(true);
    }

    /*
        Funzione che pulisce la TextView currentOperation
     */
    public void checkCurrentOperation(){
            flagResult = false;
            operationHistory.append("\n" + currentOperation.getText().toString());
            currentOperation.setText("");
    }

    /*
        Funzione che gestisce l'attivazione delle operazioni
     */
    public void enableOperationButton(boolean flag){
        if (flag == false){
            bottonePiu.setEnabled(false);
            bottoneMen.setEnabled(false);
            bottonePer.setEnabled(false);
            bottoneDiv.setEnabled(false);
            bottoneUgu.setEnabled(false);
        }else{
            bottonePiu.setEnabled(true);
            bottoneMen.setEnabled(true);
            bottonePer.setEnabled(true);
            bottoneDiv.setEnabled(true);
            bottoneUgu.setEnabled(true);
        }
    }

}
