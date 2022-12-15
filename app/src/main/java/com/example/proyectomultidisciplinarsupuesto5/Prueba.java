package com.example.proyectomultidisciplinarsupuesto5;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import android.os.Bundle;
import android.widget.LinearLayout;
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

public class Prueba extends AppCompatActivity {

    private LinearLayout layoutBody;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        layoutBody = findViewById(R.id.layoutBody);

        String URL = "http://localhost:63342/PHP_Pablo_Navarro_Vazquez/Prueba/cn.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        System.out.println(jsonObject.length());
//                        e1.setText(jsonObject.getString("nombre"));
//                        e2.setText(jsonObject.getString("apellido"));
//                        e3.setText(jsonObject.getString("direccion"));
//                        e4.setText(jsonObject.getString("telefono"));
//                        e5.setText(jsonObject.getString("correo"));
//                        e6.setText(jsonObject.getString("sexo"));
//                        e7.setText(jsonObject.getString("fecha"));

                    } catch (JSONException e) {
                        System.err.println(e.getMessage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Prueba.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
