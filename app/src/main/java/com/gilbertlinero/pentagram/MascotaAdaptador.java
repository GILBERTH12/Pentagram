package com.gilbertlinero.pentagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Win 10 on 19/06/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public  MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());;
        mascotaViewHolder.tvRaitingCV.setText(String.valueOf(mascota.getRaiting()));

        mascotaViewHolder.btnRaitear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setRaitear();
                Toast.makeText(activity, "Raiteaste a " + mascota.getNombre(), Toast.LENGTH_LONG).show();
                mascotaViewHolder.tvRaitingCV.setText(String.valueOf(mascota.getRaiting()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btnRaitear;
        private TextView tvNombreCV;
        private TextView tvRaitingCV;

        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnRaitear = (ImageButton) itemView.findViewById(R.id.btnRaitear);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV = (TextView) itemView.findViewById(R.id.tvRaitingCV);
        }
    }
}
