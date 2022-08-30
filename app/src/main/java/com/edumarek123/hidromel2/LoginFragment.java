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


public class LoginFragment extends Fragment {

    //atributos
    private EditText evUsuario;
    private EditText evSenha;
    private Button btLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View login_page=inflater.inflate(R.layout.fragment_login, container, false);

//        evUsuario = (EditText)findViewById(R.id.campo_email_login);
//        evSenha = (EditText)findViewById(R.id.campo_senha_login);

        Button botao_login=(Button)login_page.findViewById(R.id.botao_login);
        botao_login.setOnClickListener(this::l_ogar);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void l_ogar(View v){
//        Snackbar mySnackbar = Snackbar.make(v, "Erro ao logar", Snackbar.LENGTH_LONG);
//        mySnackbar.show();

        MenuFragment menu_page=new MenuFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.loginPage, menu_page);
        fragmentTransaction.commit();

    }
}