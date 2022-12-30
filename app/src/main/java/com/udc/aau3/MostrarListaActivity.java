package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.udc.aau3.controller.CustomAdapter;
import com.udc.aau3.model.Persona;

import java.util.List;

public class MostrarListaActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter adapter;
    private Intent llamarActivityIntent;

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
                startActivity(llamarActivityIntent);
            }
        });
    }
}