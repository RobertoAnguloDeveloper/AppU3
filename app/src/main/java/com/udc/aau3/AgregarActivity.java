package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

public class AgregarActivity extends AppCompatActivity {
    private TextInputEditText numero_id, nombres, apellidos, tel_contacto, email, domicilio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        numero_id = findViewById(R.id.numero_id);
        numero_id.setSingleLine(true);

        nombres = findViewById(R.id.nombres);
        nombres.setSingleLine(true);

        apellidos = findViewById(R.id.apellidos);
        apellidos.setSingleLine(true);

        tel_contacto = findViewById(R.id.tel_contacto);
        tel_contacto.setSingleLine(true);

        email = findViewById(R.id.email);
        email.setSingleLine(true);

        domicilio = findViewById(R.id.domicilio);
        domicilio.setSingleLine(true);
    }
}