package com.gilbertlinero.pentagram;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarFAB();

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

        mascotas.add(new Mascota(R.drawable.l150612172633_mascotas2, "Catty", 5));
        mascotas.add(new Mascota(R.drawable.f56ap56eb56aj56ef56e_680x381, "Ronny", 3));
        mascotas.add(new Mascota(R.drawable.las_10_mascotas_m_s_deseadas_por_los_seres_humanos_5_390x250, "Doc", 0));
        mascotas.add(new Mascota(R.drawable.mascotas, "Lazy", 2));
        mascotas.add(new Mascota(R.drawable.perrito_hermoso_salundando_255, "San", 4));
        mascotas.add(new Mascota(R.drawable.slide_2, "Bonny", 1));
        mascotas.add(new Mascota(R.drawable.limpieza_de_casas_con_mascotas_4, "Conny", 1));
    }

    public void agregarFAB(){
        FloatingActionButton fabCamara = (FloatingActionButton) findViewById(R.id.fabCamara);
        fabCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tomar una foto con la Camara", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
