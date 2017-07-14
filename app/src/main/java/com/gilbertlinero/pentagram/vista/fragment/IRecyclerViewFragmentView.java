package com.gilbertlinero.pentagram.vista.fragment;

import com.gilbertlinero.pentagram.adapter.MascotaAdaptador;
import com.gilbertlinero.pentagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Win 10 on 13/07/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
