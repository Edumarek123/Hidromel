package com.edumarek123.hidromel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //atributos

    private EditText evUsuario;
    private EditText evSenha;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        evUsuario = (EditText)findViewById(R.id.campo_email_login);
        evSenha = (EditText)findViewById(R.id.campo_senha_login);
        Button botao_login=(Button)findViewById(R.id.botao_login);
        botao_login.setOnClickListener(this::l_ogar);
    }

    public void l_ogar(View v){
        if (evUsuario.getText().toString().equals( "usuario") && evSenha.getText().toString().equals( "123")){
            Intent intent=new Intent(MainActivity.this, Menu.class);
            startActivity(intent);
        } else {
            Snackbar mySnackbar = Snackbar.make(v, "Erro ao logar", Snackbar.LENGTH_LONG);
            mySnackbar.show();
        }



    }
}