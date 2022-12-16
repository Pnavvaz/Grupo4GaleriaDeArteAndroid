package com.example.proyectomultidisciplinarsupuesto5;

import android.os.Bundle;
import android.widget.LinearLayout;

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

public class Prueba extends AppCompatActivity {

    private LinearLayout layoutBody;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        layoutBody = findViewById(R.id.layoutBody);


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

        String URL = "http://192.168.18.149/prueba/Conexion.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        System.out.println(jsonObject.getString("Titulo"));

                    } catch (JSONException e) {
                        System.err.println(e.getMessage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("/////////////////////////////////////////////////////////////////////// ERROR ///////////////////////////////////////////////////////////////////////");
                System.err.println("Error de conexión " + error.getMessage());
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
