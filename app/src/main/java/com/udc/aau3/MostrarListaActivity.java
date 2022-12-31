package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.udc.aau3.controller.CustomAdapter;
import com.udc.aau3.model.Persona;

import java.util.List;

public class MostrarListaActivity extends AppCompatActivity {
    public static ListView listView;
    public static CustomAdapter adapter;
    private Intent llamarActivityIntent;
    public static Persona personaClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        listView = findViewById(R.id.listaContactos);
        llamarActivityIntent = new Intent(this, LlamarActivity.class);

        adapter = new CustomAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                personaClicked = MainActivity.contactos.get(i);
                startActivity(llamarActivityIntent);
            }
        });
    }
}