package com.edumarek123.hidromel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_hidromel);

        Button botao_logout=(Button)findViewById(R.id.botao_logout);
        botao_logout.setOnClickListener(this::l_ogout);

        Button botao_cadastrarTanque=(Button)findViewById(R.id.botao_cadastrarTanque);
        botao_cadastrarTanque.setOnClickListener(this::cadastrar_tanque);

        Button botao_deletarTanque=(Button)findViewById(R.id.botao_deletarTanque);
        botao_deletarTanque.setOnClickListener(this::deletar_tanque);
    }

    public void l_ogout(View v) {
        Intent intent = new Intent(Menu.this, MainActivity.class);
        startActivity(intent);
    }

    public void cadastrar_tanque(View v) {

    }

    public void deletar_tanque(View v) {

    }
}