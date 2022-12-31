package com.udc.aau3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.udc.aau3.controller.ManejadorInputs;
import com.udc.aau3.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class EliminarActivity extends AppCompatActivity {
    Intent mostrarEliminarActivityIntent;
    private TextInputEditText idContact, nombresContact, apellidosContact, telefonoContact, emailContact, domicilioContact;
    private List<TextInputEditText> textInputEditTextList;
    private Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        mostrarEliminarActivityIntent = new Intent(this, MostrarEliminarActivity.class);

        textInputEditTextList = new ArrayList<>();

        idContact = findViewById(R.id.idContact);
        textInputEditTextList.add(idContact);

        nombresContact = findViewById(R.id.nombresContactE);
        textInputEditTextList.add(nombresContact);

        apellidosContact = findViewById(R.id.apellidosContactE);
        textInputEditTextList.add(apellidosContact);

        telefonoContact = findViewById(R.id.telefonoContactE);
        textInputEditTextList.add(telefonoContact);

        emailContact = findViewById(R.id.emailContactE);
        textInputEditTextList.add(emailContact);

        domicilioContact =findViewById(R.id.domicilioContactE);
        textInputEditTextList.add(domicilioContact);

        Persona contacto = MostrarEliminarActivity.personaEliminar;

        btnEliminar = findViewById(R.id.btnEliminar);

        idContact.setText(contacto.getId().toString());
        nombresContact.setText(contacto.getNombres());
        apellidosContact.setText(contacto.getApellidos());
        telefonoContact.setText(contacto.getTelefono());
        emailContact.setText(contacto.getEmail());
        domicilioContact.setText(contacto.getDomicilio());

        ManejadorInputs.disable(textInputEditTextList);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int index = 0;
                int idBuscar = Integer.valueOf(idContact.getText().toString());
                for (int i = 0; i < MainActivity.contactos.size(); i++) {
                    if(MainActivity.contactos.get(i).getId() == idBuscar){
                        index = i;
                        break;
                    }
                }

                MainActivity.contactos.remove(index);
                MostrarEliminarActivity.adapterEliminar.notifyDataSetChanged();
                finish();
                startActivity(mostrarEliminarActivityIntent);
            }
        });
    }
}