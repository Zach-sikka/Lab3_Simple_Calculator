package com.example.lab3_simple_calculator;

import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;


public class MainActivity extends Activity {


    private double data1 = 0, data2 = 0;
    private enum Operator {none, add, minus, multiply, divide, negative};
    private Operator optr = Operator.none;

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkOperator(Operator optr) {
        if (optr == Operator.none && flag == true) {
            EditText eText = (EditText)findViewById(R.id.resultEdit);
            eText.setText("");
        }
    }

    public void clickNumericalButton(View view) {

        int pressID = view.getId();

        TextView currentText = (TextView)findViewById(R.id.resultEdit);

        checkOperator(optr);

        flag = false;

        if (pressID == R.id.btn0) {
            currentText.setText(currentText.getText() + "0");
        } else if (pressID == R.id.btn1) {
            currentText.setText(currentText.getText() + "1");
        } else if (pressID == R.id.btn2) {
            currentText.setText(currentText.getText() + "2");
        } else if (pressID == R.id.btn3) {
            currentText.setText(currentText.getText() + "3");
        } else if (pressID == R.id.btn4) {
            currentText.setText(currentText.getText() + "4");
        } else if (pressID == R.id.btn5) {
            currentText.setText(currentText.getText() + "5");
        } else if (pressID == R.id.btn6) {
            currentText.setText(currentText.getText() + "6");
        } else if (pressID == R.id.btn7) {
            currentText.setText(currentText.getText() + "7");
        } else if (pressID == R.id.btn8) {
            currentText.setText(currentText.getText() + "8");
        } else if (pressID == R.id.btn9) {
            currentText.setText(currentText.getText() + "9");
        } else if (pressID == R.id.btndecimal) {
            currentText.setText(currentText.getText() + ".");
        } else {
            currentText.setText("ERROR");
        }

    }
    /*public void btn0Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "0");

    }
    public void btn1Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "1");

    }

    public void btn2Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "2");

    }

    public void btn3Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "3");

    }

    public void btn4Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "4");

    }

    public void btn5Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "5");

    }

    public void btn6Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "6");

    }

    public void btn7Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "7");

    }

    public void btn8Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "8");

    }

    public void btn9Click(View view) {
        checkOperator(optr);
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "9");

    }*/

    public void btnMultiplyClick(View view) {
        optr = Operator.multiply;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideClick(View view) {
        optr = Operator.divide;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");

    }

    public void btnAddClick(View view) {
        optr = Operator.add;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");

    }

    public void btnMinusClick(View view) {
        optr = Operator.minus;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");

    }

    public void btnClearClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText("");

    }

    /*public void btnDecimalClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + ".");

    }*/

    public void btnNegativeClick(View view) {
        //optr = Operator.negative;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        //data1 = Double.parseDouble(eText.getText().toString()) * (-1);
        eText.setText(String.valueOf(Double.parseDouble(eText.getText().toString()) * (-1)));

    }

    public void btnPercentClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(String.valueOf(Double.parseDouble(eText.getText().toString()) / (100)));

    }

    public void btnResultsClick(View view) {
        if (optr != Operator.none) {
            EditText eText = (EditText)findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add) {
                result = data1 + data2;
            } else if (optr == Operator.minus){
                result = data1 - data2;
            } else if (optr == Operator.multiply) {
                result = data1 * data2;
            } else if (optr == Operator.divide) {
                result = data1 / data2;
            } //else if (optr == Operator.negative) {
                //result = result * (-1);
            //}

            optr = Operator.none;
            data1 = result;
            flag = true;
            if ((result - (int)result) != 0) {
                eText.setText(String.valueOf(result));
            } else {
                eText.setText(String.valueOf( (int) result));
            }
        }
    }


}