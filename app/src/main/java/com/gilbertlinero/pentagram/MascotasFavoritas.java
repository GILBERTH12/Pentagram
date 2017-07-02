package com.gilbertlinero.pentagram;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.gilbertlinero.pentagram.adapter.MascotaAdaptador;
import com.gilbertlinero.pentagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        TextView mTitle = (TextView) miActionBar.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.favoritos));

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas,this);
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.f56ap56eb56aj56ef56e_680x381, "Ronny", 3));
        mascotas.add(new Mascota(R.drawable.mascotas, "Lazy", 2));
        mascotas.add(new Mascota(R.drawable.perrito_hermoso_salundando_255, "San", 4));
        mascotas.add(new Mascota(R.drawable.slide_2, "Bonny", 1));
        mascotas.add(new Mascota(R.drawable.limpieza_de_casas_con_mascotas_4, "Conny", 1));
    }
}
