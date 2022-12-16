package com.example.proyectomultidisciplinarsupuesto5;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;

public class VentanaManual extends AppCompatActivity {

    private LinearLayout layoutManual;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        layoutManual = findViewById(R.id.layoutManual);


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


}
