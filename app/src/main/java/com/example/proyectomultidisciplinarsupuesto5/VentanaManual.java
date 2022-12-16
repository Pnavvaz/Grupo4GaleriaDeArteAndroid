package com.example.proyectomultidisciplinarsupuesto5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VentanaManual extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutManual;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        layoutManual = findViewById(R.id.layoutManual);

        Bundle bundle = getIntent().getExtras();

        String tituloTxt = bundle.getString("Titulo");
        int idTitulo = bundle.getInt("idTitulo");

        TextView tituloTv = new TextView(this);
        tituloTv.setText(tituloTxt);
        tituloTv.setTextSize(40);
        tituloTv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tituloTv.setPadding(5, 5, 5, 5);

        layoutManual.addView(tituloTv);

        tituloTv.setGravity(View.TEXT_ALIGNMENT_CENTER);

        crearManual(idTitulo);

        Button btnBack = new Button(this);
        btnBack.setText("Volver");
        btnBack.setOnClickListener(this);

        layoutManual.addView(btnBack);


//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//
//        StrictMode.setThreadPolicy(policy);
//
//        try {
//            System.out.println("Ip local --> " + InetAddress.getLocalHost().getHostAddress());
//
//        } catch (
//                UnknownHostException e) {
//            System.err.println("Error --> " + e.getMessage());
//        }

    }

    private void crearManual(int idTitulo) {
        String URL = "http://11.65.4.5/proyecto/VerManual.php?idTitulo=" + idTitulo;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;

                System.out.println("AQUI");

                LinearLayout cuerpo = new LinearLayout(VentanaManual.this);

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        System.out.println("Objeto --> " + jsonObject.toString());

                        System.out.println("Texto -> " + jsonObject.getString("Textos"));

                        TextView tvCuerpo = new TextView(VentanaManual.this);
                        tvCuerpo.setText(jsonObject.getString("Textos"));

                        cuerpo.addView(tvCuerpo);

                    } catch (JSONException e) {
                        System.err.println(e.getMessage());
                    }
                }

                layoutManual.addView(cuerpo);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VentanaManual.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                System.out.println("/////////////////////////////////////////////////////////////////////// ERROR ///////////////////////////////////////////////////////////////////////");
                System.err.println("Error de conexión " + error.getMessage());
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
