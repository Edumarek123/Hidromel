package com.edumarek123.hidromel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class TanqueFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tanque_page=inflater.inflate(R.layout.fragment_tanque, container, false);



        Button botao_voltar= tanque_page.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(this::v_oltar);

        // Inflate the layout for this fragment
        return tanque_page;
    }
    public void v_oltar(View v){
        MenuFragment menu_page=new MenuFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, menu_page);
        fragmentTransaction.commit();
    }
}