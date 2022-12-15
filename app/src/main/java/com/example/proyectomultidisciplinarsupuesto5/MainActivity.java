package com.example.proyectomultidisciplinarsupuesto5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSubir, btnDescargar, btnCrear, btnRenombrar, btnBorrar, btnCorreo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubir= (Button) findViewById(R.id.subirArchivo);
        btnDescargar= (Button) findViewById(R.id.descargarArchivo);
        btnCrear= (Button) findViewById(R.id.crearCarpeta);
        btnRenombrar= (Button) findViewById(R.id.renombrarCarpetaArchivo);
        btnBorrar= (Button) findViewById(R.id.borrarCarpeta);
        btnCorreo= (Button) findViewById(R.id.correoElectronico);
        btnSubir.setOnClickListener(this);
        btnDescargar.setOnClickListener(this);
        btnCrear.setOnClickListener(this);
        btnRenombrar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnCorreo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==btnSubir.getId()){

        }else if(id==btnDescargar.getId()){

        }else if(id==btnCrear.getId()){

        }else if(id==btnRenombrar.getId()){

        }else if(id==btnBorrar.getId()){

        }else if(id==btnCorreo.getId()){

        }
    }
}
