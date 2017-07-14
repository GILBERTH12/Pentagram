package com.gilbertlinero.pentagram.pojo;

/**
 * Created by Win 10 on 19/06/2017.
 */

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int raiting;

    public Mascota(int foto, String nombre, int raiting) {
        this.nombre = nombre;
        this.foto = foto;
        this.raiting = raiting;
    }

    public Mascota() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public void setRaitear() {
        this.raiting = this.raiting + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
