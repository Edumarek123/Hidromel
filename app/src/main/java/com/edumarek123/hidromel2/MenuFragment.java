package com.edumarek123.hidromel2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View menu_page=inflater.inflate(R.layout.fragment_menu, container, false);

        Button botao_logout=(Button)menu_page.findViewById(R.id.botao_logout);
        botao_logout.setOnClickListener(this::d_eslogar);

        // Inflate the layout for this fragment
        return menu_page;
    }

    public void d_eslogar(View v){
        LoginFragment login_page=new LoginFragment();
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagesLayout, login_page);
        fragmentTransaction.commit();

    }
}