package com.gilbertlinero.pentagram.pojo;

/**
 * Created by Win 10 on 19/06/2017.
 */

public class Perfil {

    private int foto;
    private int raiting;

    public Perfil(int foto, int raiting) {
        this.foto = foto;
        this.raiting = raiting;
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

}
