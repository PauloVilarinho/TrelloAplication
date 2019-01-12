package com.example.paulo.trello.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paulo.trello.modelos.Lista;
import com.example.paulo.trello.R;

import java.util.ArrayList;
import java.util.List;

public class ListasAdapter extends RecyclerView.Adapter<ListasAdapter.ListaViewHolder> {

    List<Lista> listas ;
    Context context;

    public ListasAdapter(List<Lista> listas, Context context){
        this.context = context;
        this.listas = listas;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lista,viewGroup,false);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder listaViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder{

        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
