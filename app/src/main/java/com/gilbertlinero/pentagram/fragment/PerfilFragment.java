package com.gilbertlinero.pentagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilbertlinero.pentagram.R;
import com.gilbertlinero.pentagram.adapter.PerfilAdaptador;
import com.gilbertlinero.pentagram.pojo.Perfil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Perfil> perfiles;
    private RecyclerView rvPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfil = (RecyclerView) v.findViewById(R.id.rvPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        //glm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPerfil.setLayoutManager(glm);

        inicializarListaPerfil();
        inicializarAdaptador();

        return v;

    }

    public PerfilAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new PerfilAdaptador(perfiles,getActivity());
        rvPerfil.setAdapter(adaptador);
    }

    public void inicializarListaPerfil() {

        perfiles = new ArrayList<Perfil>();

        perfiles.add(new Perfil(R.drawable.mascotas, 5));
        perfiles.add(new Perfil(R.drawable.mascotas, 3));
        perfiles.add(new Perfil(R.drawable.mascotas, 0));
        perfiles.add(new Perfil(R.drawable.mascotas, 2));
        perfiles.add(new Perfil(R.drawable.mascotas, 4));
        perfiles.add(new Perfil(R.drawable.mascotas, 1));
        perfiles.add(new Perfil(R.drawable.mascotas, 1));
    }

}
