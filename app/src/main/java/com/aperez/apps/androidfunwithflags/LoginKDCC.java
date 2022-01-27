package com.aperez.apps.androidfunwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aperez.apps.androidfunwithflags.MainActivityKDCC;

public class LoginKDCC extends AppCompatActivity {


    EditText editTextUsuario;
    EditText editTextContraseña;

    String usuario1 = "JUGADOR1";
    String usuario2 = "JUGADOR2";
    String contraseña = "123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_kdcc);

        editTextUsuario = findViewById(R.id.editTextTextUsuario);
        editTextContraseña = findViewById(R.id.editTextTextContraseña);

    }


    public  void login (View view){
        logiarse();
    }

    private void logiarse() {

        String usuario = editTextUsuario.getText().toString();
        String contraseña = editTextContraseña.getText().toString();

        if ((usuario.equals(usuario1) &&  contraseña.equals(contraseña))||(usuario.equals(usuario2)&& contraseña.equals(contraseña))){
            //Toast.makeText(this, "se inserto con exito", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivityKDCC.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_LONG).show();
        }

    }
}