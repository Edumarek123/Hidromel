package com.edumarek123.hidromel2;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.edumarek123.hidromel2.singleton.Singleton;
import com.edumarek123.hidromel2.tanque.Tanque;
import com.edumarek123.hidromel2.usuario.Usuario;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private Usuario usuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View menu_page=inflater.inflate(R.layout.fragment_menu, container, false);

        if (usuario != null){
            d_eslogar(menu_page);
        }

        Button botao_logout= menu_page.findViewById(R.id.botao_logout);
        botao_logout.setOnClickListener(this::d_eslogar);

        Button botao_cadastrar= menu_page.findViewById(R.id.botao_cadastrartanques);
        botao_cadastrar.setOnClickListener(this::c_adastrar);

        this.usuario= Singleton.getInstance().getUsuario();

        ArrayList<Tanque> teste=new ArrayList<Tanque>();
        for (int i=0;i<4;i++){
            teste.add(new Tanque());
            teste.get(i).setNome("Tanques "+ (i + 1));
        }

        usuario.setTanques(teste);


        ListView tanques_disponiveis= menu_page.findViewById(R.id.lista_tanques);

        String[] tanques;
        if (usuario.getTanques()==null){

        }else{ //adiciona tanques de teste
            tanques=new String[usuario.getTanques().size()];

            for (int i=0;i<usuario.getTanques().size();i++)
                tanques[i]=usuario.getTanques().get(i).getNome();

            ArrayAdapter<String> arr=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tanques);
            tanques_disponiveis.setAdapter(arr);

            tanques_disponiveis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                    click_tanques(menu_page, usuario.getTanques().get(position));
                }
            });
        }

        // Inflate the layout for this fragment
        return menu_page;
    }

    public void d_eslogar(View v){
        Singleton.getInstance().setUsuario(null);

        LoginFragment login_page=new LoginFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, login_page);
        fragmentTransaction.commit();
    }

    public void click_tanques(View v, Tanque t){
        Singleton.getInstance().setTanque(t);
        TanqueFragment tanque_page=new TanqueFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, tanque_page);
        fragmentTransaction.commit();

        Snackbar mySnackbar = Snackbar.make( v,
                t.getNome(), Snackbar.LENGTH_SHORT);
        mySnackbar.show();
        }

    public void c_adastrar(View v){
        CadastrarTanques cadastartanque_page=new CadastrarTanques();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, cadastartanque_page);
        fragmentTransaction.commit();
    }
}