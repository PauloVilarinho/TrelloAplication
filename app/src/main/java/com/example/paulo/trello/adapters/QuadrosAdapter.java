package com.example.paulo.trello.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paulo.trello.OnQuadroSelect;
import com.example.paulo.trello.R;
import com.example.paulo.trello.modelos.Quadro;

import java.util.List;

import io.objectbox.Box;

public class QuadrosAdapter extends RecyclerView.Adapter<QuadrosAdapter.QuadroViewHolder> {
    private Box<Quadro> boxQuadros;
    private List<Quadro> quadros ;
    private Context context;
    public static final String PACOTE = "pacote_quadro";

    public QuadrosAdapter(Box<Quadro> quadros,Context context){
        this.boxQuadros = quadros;
        this.quadros = quadros.getAll();
        this.context = context;

    }




    @NonNull
    @Override
    public QuadroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_quadro,viewGroup,false);

        return new QuadroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuadroViewHolder viewHolder, int i) {

        final Quadro quadroAtual = quadros.get(i);

        viewHolder.txtQuadroTitulo.setText(quadroAtual.getTitulo());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),OnQuadroSelect.class);

                intent.putExtra(PACOTE,quadroAtual.id);

                v.getContext().startActivity(intent);
            }
        });


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
