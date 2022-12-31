package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.udc.aau3.controller.CustomAdapter;
import com.udc.aau3.model.Persona;

public class MostrarActualizarActivity extends AppCompatActivity {
    public static ListView listViewActualizar;
    public static CustomAdapter adapterActualizar;
    private Intent actualizarActivityIntent;
    public static Persona personaActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_actualizar);
        getSupportActionBar().setTitle("ACTUALIZAR CONTACTO");

        listViewActualizar = findViewById(R.id.listaContactosActualizar);
        actualizarActivityIntent = new Intent(this, ActualizarActivity.class);

        adapterActualizar = new CustomAdapter(this);
        listViewActualizar.setAdapter(adapterActualizar);

        listViewActualizar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                personaActualizar = MainActivity.contactos.get(i);
                startActivity(actualizarActivityIntent);
            }
        });

    }
}