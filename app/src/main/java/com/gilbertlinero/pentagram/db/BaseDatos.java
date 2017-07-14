package com.gilbertlinero.pentagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gilbertlinero.pentagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Win 10 on 9/07/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE   + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO     + " INTEGER " +
                ")";

        String queryCrearTableLikesContactos = "CREATE TABLE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_RAITING_MASCOTA_NUMERO_RAITING + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTableLikesContactos);    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotaActual.setRaiting(obtenerRaitingMascota(mascotaActual));

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

/*
    SELECT a AS current_a, COUNT(*) AS b,
   ( SELECT COUNT(*) FROM t WHERE a = current_a AND c = 'const' ) as d,
    from t group by a order by b desc
*/

    public ArrayList<Mascota> obtener5MascotasRaiting(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT " +
                ConstantesBaseDatos.TABLE_MASCOTA + "." + ConstantesBaseDatos.TABLE_MASCOTA_ID + ", " +
                ConstantesBaseDatos.TABLE_MASCOTA + "." + ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + ", " +
                ConstantesBaseDatos.TABLE_MASCOTA + "." + ConstantesBaseDatos.TABLE_MASCOTA_FOTO + ", " +
                "( SELECT COUNT(" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA+ "." + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_NUMERO_RAITING +
                ") FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA+ "." + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + " = " +
                ConstantesBaseDatos.TABLE_MASCOTA + "." + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID + ") AS raiting" +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                " ORDER BY raiting DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotaActual.setRaiting(registros.getInt(3));
            //mascotaActual.setRaiting(obtenerRaitingMascota(mascotaActual));

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarRaitingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RAITING_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerRaitingMascota(Mascota mascota){
        int raiting = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_NUMERO_RAITING + ")"+
                " FROM " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_RAITING_MASCOTA_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            raiting = registros.getInt(0);
        }

        db.close();

        return raiting;
    }
}
