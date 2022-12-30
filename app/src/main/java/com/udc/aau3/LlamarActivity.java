package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.udc.aau3.controller.ManejadorInputs;
import com.udc.aau3.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class LlamarActivity extends AppCompatActivity {
    TextInputEditText idContact, nombresContact, apellidosContact, telefonoContact, emailContact, domicilioContact;
    List<TextInputEditText> textInputEditTextList;
    Button btnLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);

        textInputEditTextList = new ArrayList<>();

        idContact = findViewById(R.id.idContact);
        textInputEditTextList.add(idContact);

        nombresContact = findViewById(R.id.nombresContact);
        textInputEditTextList.add(nombresContact);

        apellidosContact = findViewById(R.id.apellidosContact);
        textInputEditTextList.add(apellidosContact);

        telefonoContact = findViewById(R.id.telefonoContact);
        textInputEditTextList.add(telefonoContact);

        emailContact = findViewById(R.id.emailContact);
        textInputEditTextList.add(emailContact);

        domicilioContact =findViewById(R.id.domicilioContact);
        textInputEditTextList.add(domicilioContact);

        Persona contacto = MostrarListaActivity.personaClicked;

        btnLlamar = findViewById(R.id.btnLlamar);

        idContact.setText(contacto.getId().toString());
        nombresContact.setText(contacto.getNombres());
        apellidosContact.setText(contacto.getApellidos());
        telefonoContact.setText(contacto.getTelefono());
        emailContact.setText(contacto.getEmail());
        domicilioContact.setText(contacto.getDomicilio());

        ManejadorInputs.disable(textInputEditTextList);

        btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:" + contacto.getTelefono())));
            }
        });
    }
}