package com.gilbertlinero.pentagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gilbertlinero.pentagram.R;
import com.gilbertlinero.pentagram.pojo.Perfil;

import java.util.ArrayList;

/**
 * Created by Win 10 on 19/06/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

    ArrayList<Perfil> perfiles;
    Activity activity;

    public PerfilAdaptador(ArrayList<Perfil> perfiles, Activity activity){
        this.perfiles = perfiles;
        this.activity = activity;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder perfilViewHolder, int position) {
        final Perfil perfil = perfiles.get(position);
        perfilViewHolder.imgFoto.setImageResource(perfil.getFoto());
        perfilViewHolder.tvRaitingCV.setText(String.valueOf(perfil.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return perfiles.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvRaitingCV;

        public PerfilViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
        }
    }
}
