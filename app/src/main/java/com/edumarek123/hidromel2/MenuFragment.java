package com.edumarek123.hidromel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.edumarek123.hidromel2.usuario.Usuario;

public class MenuFragment extends Fragment {

    private Usuario usuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View menu_page=inflater.inflate(R.layout.fragment_menu, container, false);

        if (usuario != null){
            d_eslogar(menu_page);
        }

        Button botao_logout=(Button)menu_page.findViewById(R.id.botao_logout);
        botao_logout.setOnClickListener(this::d_eslogar);

        this.usuario=Singleton.getInstance().getUsuario();

        ListView tanques_disponiveis=(ListView) menu_page.findViewById(R.id.lista_tanques);

        String tanques[]={"Tanque 1", "Tanque 2", "Tanque 3", "Tanque 4"};
        ArrayAdapter<String> arr=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tanques);
        tanques_disponiveis.setAdapter(arr);

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
}