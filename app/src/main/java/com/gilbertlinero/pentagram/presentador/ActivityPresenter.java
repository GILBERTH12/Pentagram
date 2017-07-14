package com.gilbertlinero.pentagram.presentador;

import android.content.Context;

import com.gilbertlinero.pentagram.db.ConstructorMascotas;
import com.gilbertlinero.pentagram.db.ConstructorMascotasFavoritas;
import com.gilbertlinero.pentagram.pojo.Mascota;
import com.gilbertlinero.pentagram.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

/**
 * Created by Win 10 on 13/07/2017.
 */

public class ActivityPresenter implements IActivityPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotasFavoritas constructorMascotasFavoritas;
    private ArrayList<Mascota> mascotas;

    public ActivityPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotasFavoritas = new ConstructorMascotasFavoritas(context);
        mascotas = constructorMascotasFavoritas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
