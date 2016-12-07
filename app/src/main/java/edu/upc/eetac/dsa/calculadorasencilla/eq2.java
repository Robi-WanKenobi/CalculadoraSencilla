package edu.upc.eetac.dsa.calculadorasencilla;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static java.lang.Math.sqrt;

/**
 * Created by Roberto on 29/11/2016.
 */

public class eq2 extends AppCompatActivity {

    String tag = "Events";
    float a, b, c;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eq2);
        Log.d(tag, "Event onCreate()");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Log.d(tag, "Event onStart()");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
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
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        Log.d(tag, "Event onStop()");

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "Event onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "Event onDestroy()");

    }

    public void calcular(View v) {

        TextView res1 = (TextView) findViewById(R.id.res1);
        TextView res2 = (TextView) findViewById(R.id.res2);
        res1.setText(null);
        res2.setText(null);

        try {

            EditText e1 = (EditText) findViewById(R.id.a);
            EditText e2 = (EditText) findViewById(R.id.b);
            EditText e3 = (EditText) findViewById(R.id.c);
            a = Float.parseFloat(e1.getText().toString());
            b = Float.parseFloat(e2.getText().toString());
            c = Float.parseFloat(e3.getText().toString());
            Log.d(tag, "Números: " + a + " " + b + " " + c);

            float sol1, sol2 = 0;
            Log.d(tag, "Discriminante: " + ((b * b) - (4 * (a) * (c))));
            float discriminante = ((b * b) - (4 * (a) * (c)));

            if (a == 0){
                sol1 = -c/b;
                sol2 = -c/b;

                TextView result1 = (TextView) findViewById(R.id.res1);
                TextView result2 = (TextView) findViewById(R.id.res2);
                result1.setText("" + sol1);
                result2.setText("" + sol2);
            }
            else if (discriminante < 0) {
                Context f = getApplicationContext();
                CharSequence t = "La ecuación no tiene solución";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(f, t, duration);
                toast.show();
            } else if ((discriminante > 0) || (discriminante == 0)) {

                TextView result1 = (TextView) findViewById(R.id.res1);
                TextView result2 = (TextView) findViewById(R.id.res2);

                sol1 = (float) (((-b) + sqrt(discriminante)) / (2 * a));
                sol2 = (float) (((-b) - sqrt(discriminante)) / (2 * a));
                Log.d(tag, "Soluciones: " + sol1 + " " + sol2);

                result1.setText("" + sol1);
                result2.setText("" + sol2);

                if (discriminante == 0) {

                    Context o = getApplicationContext();
                    CharSequence t = "La ecuación tiene una única solución";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(o, t, duration);
                    toast.show();

                }

            }

            TextView ecuacion = (TextView) findViewById(R.id.ecuacion);

            char signoB = '+';
            char signoC = '+';
            int mostrarA, mostrarB, mostrarC;

            if (b < 0) signoB = ' ';
            if (c < 0) signoC = ' ';

            //Si no se quita el 0.0 lo borro
            mostrarA = (int) a;
            mostrarB = (int) b;
            mostrarC = (int) c;

            if ((mostrarA != 0) && (mostrarB != 0) && (mostrarC != 0)) {
                ecuacion.setText("Ecuación:  " + mostrarA + "x² " + signoB + mostrarB + "x " + signoC + mostrarC + "  =  0");
            }
            else if (mostrarA == 0){
                ecuacion.setText("Ecuación:  " + signoB + mostrarB + "x " + signoC + mostrarC + "  =  0");

                Context grad1 = getApplicationContext();
                CharSequence t = "Esto es una ecuación de primer grado";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(grad1, t, duration);
                toast.show();
            }
            else if (mostrarB == 0){
                ecuacion.setText("Ecuación:  " + mostrarA + "x² " + signoC + mostrarC + "  =  0");
            }
            else if (mostrarC == 0){
                ecuacion.setText("Ecuación:  " + mostrarA + "x² " + signoB + mostrarB + "x  =  0");
            }


        } catch (Exception e) {

            Context c = getApplicationContext();
            CharSequence t = "Indique los dos números de la operación";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(c, t, duration);
            toast.show();
        }
    }

    public void borrar(View v) {

        TextView valor1 = (TextView) findViewById(R.id.a);
        TextView valor2 = (TextView) findViewById(R.id.b);
        TextView valor3 = (TextView) findViewById(R.id.c);
        TextView res1 = (TextView) findViewById(R.id.res1);
        TextView res2 = (TextView) findViewById(R.id.res2);
        valor1.setText(null);
        valor2.setText(null);
        valor3.setText(null);
        res1.setText(null);
        res2.setText(null);

        Context context = getApplicationContext();
        CharSequence text = "Valores borrados";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("eq2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
}
