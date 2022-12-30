package com.udc.aau3.controller;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class Validador {
    public static void limpiarCampos(List<TextInputEditText> inputs){
        for (int i = 0; i < inputs.size(); i++) {
            inputs.get(i).setText("");
        }
    }
}
