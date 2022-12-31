package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.udc.aau3.controller.CustomAdapter;
import com.udc.aau3.model.Persona;

public class MostrarEliminarActivity extends AppCompatActivity {
    public static ListView listViewEliminar;
    public static CustomAdapter adapterEliminar;
    private Intent eliminarActivityIntent;
    public static Persona personaEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_eliminar);
        getSupportActionBar().setTitle("ELIMINAR CONTACTO");

        listViewEliminar = findViewById(R.id.listaContactosEliminar);
        eliminarActivityIntent = new Intent(this, EliminarActivity.class);

        adapterEliminar = new CustomAdapter(this);
        listViewEliminar.setAdapter(adapterEliminar);

        listViewEliminar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                personaEliminar = MainActivity.contactos.get(i);
                startActivity(eliminarActivityIntent);
            }
        });
    }
}