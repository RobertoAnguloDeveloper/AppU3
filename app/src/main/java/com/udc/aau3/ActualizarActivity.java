package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.udc.aau3.controller.ManejadorInputs;
import com.udc.aau3.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class ActualizarActivity extends AppCompatActivity {
    private TextInputEditText idContact, nombresContact, apellidosContact, telefonoContact, emailContact, domicilioContact;
    private List<TextInputEditText> textInputEditTextList;
    private Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        textInputEditTextList = new ArrayList<>();

        idContact = findViewById(R.id.idContact);
        textInputEditTextList.add(idContact);

        nombresContact = findViewById(R.id.nombresContactA);

        apellidosContact = findViewById(R.id.apellidosContactA);

        telefonoContact = findViewById(R.id.telefonoContactA);

        emailContact = findViewById(R.id.emailContactA);

        domicilioContact =findViewById(R.id.domicilioContactA);

        Persona contacto = MostrarActualizarActivity.personaActualizar;

        btnActualizar = findViewById(R.id.btnActualizar);

        idContact.setText(contacto.getId().toString());
        nombresContact.setText(contacto.getNombres());
        apellidosContact.setText(contacto.getApellidos());
        telefonoContact.setText(contacto.getTelefono());
        emailContact.setText(contacto.getEmail());
        domicilioContact.setText(contacto.getDomicilio());

        ManejadorInputs.disable(textInputEditTextList);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona contactoEditado = new Persona(Integer.valueOf(idContact.getText().toString())
                        , nombresContact.getText().toString(), apellidosContact.getText().toString()
                        , telefonoContact.getText().toString(), emailContact.getText().toString()
                        ,domicilioContact.getText().toString());

                int index = 0;
                int idBuscar = Integer.valueOf(idContact.getText().toString());
                for (int i = 0; i < MainActivity.contactos.size(); i++) {
                    if(MainActivity.contactos.get(i).getId() == idBuscar){
                        index = i;
                        break;
                    }
                }

                contactoEditado.setImagen(MainActivity.contactos.get(index).getImagen());

                MainActivity.contactos.set(index, contactoEditado);
                MostrarListaActivity.adapter.notifyDataSetChanged();
                MostrarActualizarActivity.adapterActualizar.notifyDataSetChanged();
            }
        });
    }
}