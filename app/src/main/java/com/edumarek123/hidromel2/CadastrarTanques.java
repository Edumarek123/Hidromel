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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.edumarek123.hidromel2.tanque.Tanque;
import com.google.android.material.snackbar.Snackbar;

public class CadastrarTanques extends Fragment implements
        Response.ErrorListener, Response.Listener{

    private EditText tqNome;
    private EditText tqBebida;
    private EditText tqEspecificacoes;
    private EditText tqVolume;

    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;

    private View cadastartanque_page;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.cadastartanque_page=inflater.inflate(R.layout.fragment_cadastrar_tanques, container, false);

        tqNome = cadastartanque_page.findViewById(R.id.campo_nome_cadastrar_tanque);
        tqBebida = cadastartanque_page.findViewById(R.id.campo_bebida_cadastrar_tanque);
        tqEspecificacoes = cadastartanque_page.findViewById(R.id.campo_especificacoes_cadastrar_tanque);
        tqVolume = cadastartanque_page.findViewById(R.id.campo_volume_cadastrar_tanque);

        Button botao_voltar= cadastartanque_page.findViewById(R.id.botao_voltar);
        botao_voltar.setOnClickListener(this::v_oltar);

        Button botao_cadastrar_tanque= cadastartanque_page.findViewById(R.id.botao_cadastrar_tanque1);
        botao_cadastrar_tanque.setOnClickListener(this::c_adastar);
        requestQueue = Volley.newRequestQueue(cadastartanque_page.getContext());
        requestQueue.start();
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
        t.setNome(tqNome.getText().toString());
        t.setBebida(tqBebida.getText().toString());
        t.setEspecificacoes(tqEspecificacoes.getText().toString());
        t.setVolume(12);

        jsonObjectReq = new JsonObjectRequest(
                Request.Method.POST,
                "http://10.0.2.2:8080/hidromel/rest/tanque",
                t.toJsonObject(), this, this);
        requestQueue.add(jsonObjectReq);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Snackbar mySnackbar = Snackbar.make( cadastartanque_page,
                error.toString(), Snackbar.LENGTH_SHORT);
        mySnackbar.show();
    }

    @Override
    public void onResponse(Object response) {
        MenuFragment menu_page=new MenuFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, menu_page);
        fragmentTransaction.commit();
    }
}