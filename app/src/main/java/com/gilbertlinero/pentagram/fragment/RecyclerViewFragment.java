package com.gilbertlinero.pentagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gilbertlinero.pentagram.R;
import com.gilbertlinero.pentagram.adapter.MascotaAdaptador;
import com.gilbertlinero.pentagram.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recyclerview, container, false);

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.l150612172633_mascotas2, "Catty", 5));
        mascotas.add(new Mascota(R.drawable.f56ap56eb56aj56ef56e_680x381, "Ronny", 3));
        mascotas.add(new Mascota(R.drawable.las_10_mascotas_m_s_deseadas_por_los_seres_humanos_5_390x250, "Doc", 0));
        mascotas.add(new Mascota(R.drawable.mascotas, "Lazy", 2));
        mascotas.add(new Mascota(R.drawable.perrito_hermoso_salundando_255, "San", 4));
        mascotas.add(new Mascota(R.drawable.slide_2, "Bonny", 1));
        mascotas.add(new Mascota(R.drawable.limpieza_de_casas_con_mascotas_4, "Conny", 1));
    }
}
