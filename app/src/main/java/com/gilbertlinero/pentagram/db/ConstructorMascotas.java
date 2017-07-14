package com.gilbertlinero.pentagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.gilbertlinero.pentagram.R;
import com.gilbertlinero.pentagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Win 10 on 9/07/2017.
 */

public class ConstructorMascotas {

    private static final int RAITING = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.l150612172633_mascotas2, "Catty", 5));
        mascotas.add(new Mascota(R.drawable.f56ap56eb56aj56ef56e_680x381, "Ronny", 3));
        mascotas.add(new Mascota(R.drawable.las_10_mascotas_m_s_deseadas_por_los_seres_humanos_5_390x250, "Doc", 0));
        mascotas.add(new Mascota(R.drawable.mascotas, "Lazy", 2));
        mascotas.add(new Mascota(R.drawable.perrito_hermoso_salundando_255, "San", 4));
        mascotas.add(new Mascota(R.drawable.slide_2, "Bonny", 1));
        mascotas.add(new Mascota(R.drawable.limpieza_de_casas_con_mascotas_4, "Conny", 1));
        */

        BaseDatos db = new BaseDatos(context);
        insertarSieteMascotas(db);
        return db.obtenerTodosLasMascotas();
    }

    public void insertarSieteMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Catty");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.l150612172633_mascotas2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Ronny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.f56ap56eb56aj56ef56e_680x381);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Doc");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.las_10_mascotas_m_s_deseadas_por_los_seres_humanos_5_390x250);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lazy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascotas);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "San");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perrito_hermoso_salundando_255);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bonny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.slide_2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Conny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.limpieza_de_casas_con_mascotas_4);
        db.insertarMascota(contentValues);
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
