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

import com.edumarek123.hidromel2.singleton.Singleton;
import com.edumarek123.hidromel2.usuario.Usuario;
import com.google.android.material.snackbar.Snackbar;


public class LoginFragment extends Fragment{

    //atributos
    private EditText evEmail;
    private EditText evSenha;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View login_page=inflater.inflate(R.layout.fragment_login, container, false);

        evEmail = login_page.findViewById(R.id.campo_email_login);
        evSenha = login_page.findViewById(R.id.campo_senha_login);

        Button botao_login= login_page.findViewById(R.id.botao_login);
        botao_login.setOnClickListener(this::l_ogar);


        // Inflate the layout for this fragment
        return login_page;
    }
//
    public void l_ogar(View v){
        if (evEmail.getText().toString().equals("") && evSenha.getText().toString().equals("")){
            Usuario usuario=new Usuario();

           Singleton.getInstance().setUsuario(usuario);

            MenuFragment menu_page=new MenuFragment();
//            menu_page.setArguments(bundle_usuario);
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