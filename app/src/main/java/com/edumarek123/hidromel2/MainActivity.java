package com.edumarek123.hidromel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //atributos

    private EditText tvUsuario;
    private EditText tvSenha;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUsuario = (EditText)findViewById(R.id.campo_email_login);
        tvSenha = (EditText)findViewById(R.id.campo_senha_login);
        Button botao_login=(Button)findViewById(R.id.botao_login);
        botao_login.setOnClickListener(this::onClick);
    }

    public void onClick(View campos_login){
        if (tvUsuario.getText().toString().equals( "usuario") && tvSenha.getText().toString().equals( "123")){
            Intent intent=new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
        } else {
            Snackbar mySnackbar = Snackbar.make(campos_login,
                    "Erro", Snackbar.LENGTH_LONG);
            mySnackbar.show();
        }



    }
}