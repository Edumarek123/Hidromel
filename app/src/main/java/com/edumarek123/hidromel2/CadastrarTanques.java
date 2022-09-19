package com.edumarek123.hidromel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.edumarek123.hidromel2.tanque.Tanque;
import com.google.android.material.snackbar.Snackbar;

public class CadastrarTanques extends Fragment {

    private EditText tqNome;
    private EditText tqBebida;
    private EditText tqEspecificacoes;
    private EditText tqVolume;

    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View cadastartanque_page=inflater.inflate(R.layout.fragment_cadastrar_tanques, container, false);

        tqNome = cadastartanque_page.findViewById(R.id.campo_nome_cadastrar_tanque);
        tqBebida = cadastartanque_page.findViewById(R.id.campo_bebida_cadastrar_tanque);
        tqEspecificacoes = cadastartanque_page.findViewById(R.id.campo_especificacoes_cadastrar_tanque);
        tqVolume = cadastartanque_page.findViewById(R.id.campo_volume_cadastrar_tanque);

        Button botao_voltar= cadastartanque_page.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(this::v_oltar);

        Button botao_cadastrar_tanque= cadastartanque_page.findViewById(R.id.botao_cadastrar_tanque);
        botao_cadastrar_tanque.setOnClickListener(this::v_oltar);

        // Inflate the layout for this fragment
        return cadastartanque_page;
    }
    public void v_oltar(View v){
        MenuFragment menu_page=new MenuFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, menu_page);
        fragmentTransaction.commit();
    }

    public void c_adastar(View v){

        Tanque t=new Tanque();
        t.setNome(tqNome.toString());
        t.setBebida(tqBebida.toString());
        t.setEspecificacoes(tqEspecificacoes.toString());
        t.setVolume(Float.valueOf(tqEspecificacoes.toString()));

        jsonObjectReq = new JsonObjectRequest(
                Request.Method.POST,
                "http://localhost:8080/hidromel/rest/tanque",
                t.toJsonObject(), null, null);
        requestQueue.add(jsonObjectReq);

        requestQueue = Volley.newRequestQueue(v.getContext());
        requestQueue.start();

        MenuFragment menu_page=new MenuFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, menu_page);
        fragmentTransaction.commit();
    }
}