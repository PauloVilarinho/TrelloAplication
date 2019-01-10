package com.example.paulo.trello.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Quadro {

    @Id public long id;

    private String titulo;
    private ToMany<Lista> listas;

    public Quadro() {}

    public Quadro (String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ToMany<Lista> getListas() {
        return listas;
    }

    public boolean removeLista(long id) {
        if (this.listas.removeById(id) != null){
            return true;
        }
        return false;
    }

    public void addLista (Lista lista) {
        this.listas.add(lista);
    }





}

