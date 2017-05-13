package edu.upc.eetac.dsa.calculadorasencilla;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {

    String tag = "Calculadora"; //Tag para indicar el ciclo de vida de la app
    String op;
    StringBuilder historial = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        Log.d(tag,"Event onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "Event onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "Event onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "Event onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "Event onStop()");

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(tag, "Event onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "Event onDestroy()");

    }

    public void borrar(View view){
        TextView valor1 = (TextView) findViewById(R.id.v1);
        TextView valor2 = (TextView) findViewById(R.id.v2);
        TextView res = (TextView) findViewById(R.id.res);
        valor1.setText(null);
        valor2.setText(null);
        res.setText(null);

        //Mensaje chorra en pantalla con información
        Context context = getApplicationContext();
        CharSequence text = "Valores borrados";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void getOp(View v){

        boolean checked = ((RadioButton)v).isChecked();
        op = null;

        switch (v.getId()){
            case R.id.suma:
                if (checked) op = "+";
                break;
            case R.id.resta:
                if (checked) op = "-";
                break;
            case R.id.multi:
                if (checked) op = "*";
                break;
            case R.id.div:
                if (checked) op ="/";
                break;
        }
        System.out.println(op);
    }

    public void resultado (View v){

       try {
           EditText e1 = (EditText) findViewById(R.id.v1);
           EditText e2 = (EditText) findViewById(R.id.v2);
           float num1 = Float.parseFloat(e1.getText().toString());
           float num2 = Float.parseFloat(e2.getText().toString());
           Log.d(tag,"Números: " + num1 + " " + num2);

               float sol = 0;
               if ("+".equals(op)) sol = (num1 + num2);
               if ("-".equals(op)) sol = (num1 - num2);
               if ("*".equals(op)) sol = (num1 * num2);
               if ("/".equals(op)) sol = (num1 / num2);

               TextView result = (TextView) findViewById(R.id.res);
               result.setText("" + sol);

               historial.append(getOperacion(num1, num2, op, sol));
       }
       catch (Exception e){

           Context c = getApplicationContext();
           CharSequence t = "Indique los dos números de la operación";
           int duration = Toast.LENGTH_SHORT;

           Toast toast = Toast.makeText(c,t,duration);
           toast.show();
       }
    }

    public String getOperacion(float num1, float num2, String op,float result){
        StringBuilder sb = new StringBuilder();
        sb.append(num1);
        sb.append(" "+op+" ");
        sb.append(num2);
        sb.append(" = ");
        sb.append(result);
        sb.append(",");
        return sb.toString();
    }

    public void eq2 (View v){

        Intent inb1 = new Intent(Calculadora.this, eq2.class);
        startActivity(inb1);
    }

    public void showH (View v){

        Intent inb2 = new Intent(Calculadora.this, Historial.class);
        inb2.putExtra("ops", historial.toString());
        startActivity(inb2);
    }
}
