package com.example.proyectomultidisciplinarsupuesto5;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VentanaManual extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutManual;
    private RequestQueue requestQueue;
    private ArrayList<ImageView> imageViewArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones);

        layoutManual = findViewById(R.id.layoutManual);

        Bundle bundle = getIntent().getExtras();

        String tituloTxt = bundle.getString("Titulo");
        int idTitulo = bundle.getInt("idTitulo");

        TextView tituloTv = new TextView(this);
        tituloTv.setText(tituloTxt);
        tituloTv.setTextSize(40);
        tituloTv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tituloTv.setPadding(5, 5, 5, 100);

        layoutManual.addView(tituloTv);

        tituloTv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        agregarImagenes(idTitulo);
        crearManual(idTitulo);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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

    private void agregarImagenes(int idTitulo) {
        switch (idTitulo) {
            case 1:
                agregarImagen(R.mipmap.subir_archivo_1);
                agregarImagen(R.mipmap.subir_archivo_2);
                agregarImagen(R.mipmap.subir_archivo_3);
                agregarImagen(R.mipmap.subir_archivo_4);
                break;
            case 2:
                agregarImagen(R.mipmap.descargar_archivo_1);
                agregarImagen(R.mipmap.descargar_archivo_2);
                agregarImagen(R.mipmap.descargar_archivo_3);
                break;
            case 3:
                agregarImagen(R.mipmap.crear_carpeta_1);
                agregarImagen(R.mipmap.crear_carpeta_2);
                break;
            case 4:
                agregarImagen(R.mipmap.renombrar_carpeta_archivo_1);
                agregarImagen(R.mipmap.renombrar_carpeta_archivo_2);
                break;
            case 5:
                agregarImagen(R.mipmap.eliminar_carpeta_1);
                agregarImagen(R.mipmap.eliminar_carpeta_2);
                break;
            case 6:
                agregarImagen(R.mipmap.correo_electronico_1);
                agregarImagen(R.mipmap.correo_electronico_2);
                agregarImagen(R.mipmap.correo_electronico_3);
                agregarImagen(R.mipmap.correo_electronico_4);
                agregarImagen(R.mipmap.correo_electronico_5);
                agregarImagen(R.mipmap.correo_electronico_6);
                break;
            case 7:
                agregarImagen(R.mipmap.eliminar_archivo_1);
                agregarImagen(R.mipmap.eliminar_archivo_2);
                break;
            case 8:
                agregarImagen(R.mipmap.restablecer_contra_1);
                agregarImagen(R.mipmap.restablecer_contra_2);
                agregarImagen(R.mipmap.restablecer_contra_3);
                break;
            case 9:
                agregarImagen(R.mipmap.soporte_tecnico_1);
                agregarImagen(R.mipmap.soporte_tecnico_2);
                break;
            case 10:
                agregarImagen(R.mipmap.soporte_tecnico_2);
                break;
        }
    }

    private void agregarImagen(int id) {
        ImageView img = new ImageView(this);
        img.setImageResource(id);
        imageViewArrayList.add(img);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void crearManual(int idTitulo) {
     String URL = "http://192.168.56.1/prueba/VerManual.php?idTitulo=" + idTitulo;
       // String URL = "http://11.65.4.5/prueba/VerManual.php?idTitulo=" + idTitulo;
        // String URL = "http://192.168.18.149/prueba/VerManual.php?idTitulo=" + idTitulo;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        System.out.println("Texto -> " + jsonObject.getString("Textos"));

                        TextView tvCuerpo = new TextView(VentanaManual.this);
                        tvCuerpo.setText(jsonObject.getString("Textos"));
                        tvCuerpo.setTextSize(16);
                        layoutManual.addView(tvCuerpo);
                        layoutManual.addView(imageViewArrayList.get(i));

                    } catch (JSONException e) {
                        System.err.println(e.getMessage());
                    }
                }
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
