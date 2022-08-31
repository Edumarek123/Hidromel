package com.edumarek123.hidromel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class LoginFragment extends Fragment{

    //atributos
    private EditText evUsuario;
    private EditText evSenha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View login_page=inflater.inflate(R.layout.fragment_login, container, false);

        evUsuario = (EditText)login_page.findViewById(R.id.campo_email_login);
        evSenha = (EditText)login_page.findViewById(R.id.campo_senha_login);

        Button botao_login=(Button)login_page.findViewById(R.id.botao_login);
        botao_login.setOnClickListener(this::l_ogar);


        // Inflate the layout for this fragment
        return login_page;
    }

    public void l_ogar(View v){
        if (evUsuario.getText().toString().equals("") && evSenha.getText().toString().equals("")){
            MenuFragment menu_page=new MenuFragment();
            FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.pagesLayout, menu_page);
            fragmentTransaction.commit();
        } else{
            Snackbar mySnackbar = Snackbar.make( v,
                    "Erro ao Logar", Snackbar.LENGTH_SHORT);
            mySnackbar.show();
        }

    }


}