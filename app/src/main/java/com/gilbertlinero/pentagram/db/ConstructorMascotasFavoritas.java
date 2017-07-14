package com.gilbertlinero.pentagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.gilbertlinero.pentagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Win 10 on 13/07/2017.
 */

public class ConstructorMascotasFavoritas {

    private static final int RAITING = 1;
    private Context context;

    public ConstructorMascotasFavoritas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.f56ap56eb56aj56ef56e_680x381, "Ronny", 3));
        mascotas.add(new Mascota(R.drawable.mascotas, "Lazy", 2));
        mascotas.add(new Mascota(R.drawable.perrito_hermoso_salundando_255, "San", 4));
        mascotas.add(new Mascota(R.drawable.slide_2, "Bonny", 1));
        mascotas.add(new Mascota(R.drawable.limpieza_de_casas_con_mascotas_4, "Conny", 1));
        */

        BaseDatos db = new BaseDatos(context);
        return db.obtener5MascotasRaiting();
    }

    public void darRaitingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RAITING_MASCOTA_NUMERO_RAITING, RAITING);
        db.insertarRaitingMascota(contentValues);
    }

    public int obtenerRaitingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaitingMascota(mascota);
    }
}
