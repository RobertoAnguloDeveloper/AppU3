package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.udc.aau3.controller.Validador;
import com.udc.aau3.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class AgregarActivity extends AppCompatActivity {
    private TextInputEditText id, nombres, apellidos, tel_contacto, email, domicilio;
    private List<TextInputEditText> inputs;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        inputs = new ArrayList<>();

        id = findViewById(R.id.id);

        //String idNum = (MainActivity.contactos.size()+1)+"";
        String query = "SELECT seq FROM sqlite_sequence WHERE name='"+MainActivity.tableName+"';";
        Cursor cursor = MainActivity.sqLiteRead.rawQuery(query, null);
        cursor.moveToFirst();

        String resultQuery = (cursor.getInt(0)+1)+"";

        id.setText(resultQuery);
        //id.setText(idNum);
        id.setEnabled(false);

        nombres = findViewById(R.id.nombres);
        nombres.setSingleLine(true);
        inputs.add(nombres);

        apellidos = findViewById(R.id.apellidos);
        apellidos.setSingleLine(true);
        inputs.add(apellidos);

        tel_contacto = findViewById(R.id.tel_contacto);
        tel_contacto.setSingleLine(true);
        inputs.add(tel_contacto);

        email = findViewById(R.id.email);
        email.setSingleLine(true);
        inputs.add(email);

        domicilio = findViewById(R.id.domicilio);
        domicilio.setSingleLine(true);
        inputs.add(domicilio);

        btnAgregar = findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = new Persona(Integer.valueOf(id.getText().toString()), nombres.getText().toString(),
                        apellidos.getText().toString(),
                        email.getText().toString(), domicilio.getText().toString());

                MainActivity.contactos.add(persona);

                ContentValues contentValues = new ContentValues();

                contentValues.put("nombres",persona.getNombres());
                contentValues.put("apellidos",persona.getApellidos());
                contentValues.put("email",persona.getEmail());
                contentValues.put("domicilio",persona.getDomicilio());
                MainActivity.sqLiteWrite.insert(MainActivity.tableName, null, contentValues);

                Validador.limpiarCampos(inputs);
                id.setEnabled(true);
                id.setText(Integer.valueOf(id.getText().toString())+1+"");
                id.setEnabled(false);
                Toast.makeText(AgregarActivity.this, "CONTACTO GUARDADO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}