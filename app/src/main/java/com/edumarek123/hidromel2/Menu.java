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
        botao_logout.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Intent intent = new Intent(Menu.this, MainActivity.class);
        startActivity(intent);
    }
}