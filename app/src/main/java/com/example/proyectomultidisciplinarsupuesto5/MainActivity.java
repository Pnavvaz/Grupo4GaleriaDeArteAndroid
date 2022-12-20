package com.example.proyectomultidisciplinarsupuesto5;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
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

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private GridLayout gridBtns;
    private Drawable drawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawable= getDrawable(R.drawable.bordes);
        gridBtns = findViewById(R.id.gridBtns);

        crearBotones();
    }

    private void crearBotones() {
//        String URL = "http://192.168.56.1/prueba/Conexion.php";
        String URL = "http://11.65.4.5/prueba/Conexion.php";
//        String URL = "http://192.168.18.149/prueba/Conexion.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        Button btnTitle = new Button(getApplicationContext());
                        btnTitle.setText(jsonObject.getString("Titulo"));
                        btnTitle.setTag(jsonObject.getInt("Id"));

                        GridLayout.LayoutParams params = new GridLayout.LayoutParams();

                       //if(btnTitle.getText())
                        btnTitle.setLayoutParams(params);
                        btnTitle.setTextSize(20);
                        btnTitle.setBackground(drawable);
                        btnTitle.setGravity(Gravity.CENTER_HORIZONTAL);
                        btnTitle.setTextColor(Color.WHITE);
                        btnTitle.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);

                        params.setMargins(120,15,120,100);
                        btnTitle.setWidth(450);
                        btnTitle.setHeight(350);
                        btnTitle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Button btn = (Button) view;
                                Intent i = new Intent(getApplicationContext(), VentanaManual.class);

                                Bundle bundle = new Bundle();
                                bundle.putString("Titulo", btn.getText().toString());
                                bundle.putInt("idTitulo", Integer.parseInt(btn.getTag().toString()));

                                i.putExtras(bundle);
                                startActivity(i);
                            }
                        });

                        gridBtns.addView(btnTitle);

                    } catch (JSONException e) {
                        System.err.println(e.getMessage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                System.out.println("/////////////////////////////////////////////////////////////////////// ERROR ///////////////////////////////////////////////////////////////////////");
                System.err.println("Error de conexión " + error.getMessage());
            }
        }
        );
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}