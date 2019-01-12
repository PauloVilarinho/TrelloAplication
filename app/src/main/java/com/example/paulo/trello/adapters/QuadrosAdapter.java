package com.example.paulo.trello.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paulo.trello.R;
import com.example.paulo.trello.modelos.Quadro;

import java.util.List;

public class QuadrosAdapter extends RecyclerView.Adapter<QuadrosAdapter.QuadroViewHolder> {

    private List<Quadro> quadros ;
    private Context context;

    public QuadrosAdapter(List<Quadro> quadros,Context context){

        this.quadros = quadros;
        this.context = context;

    }




    @NonNull
    @Override
    public QuadroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout,viewGroup,false);

        return new QuadroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuadroViewHolder viewHolder, int i) {

        Quadro quadroAtual = quadros.get(i);

        viewHolder.txtQuadroTitulo.setText(quadroAtual.getTitulo());


    }

    @Override
    public int getItemCount() {
        return this.quadros.size();
    }

    public class QuadroViewHolder extends RecyclerView.ViewHolder{

        TextView txtQuadroTitulo;

        public QuadroViewHolder(@NonNull View itemView) {
            super(itemView);

            txtQuadroTitulo = itemView.findViewById(R.id.txt_quadro_nome);
        }
    }
}
