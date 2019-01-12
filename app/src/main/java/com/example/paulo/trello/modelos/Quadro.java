package com.example.paulo.trello.modelos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Quadro {

    @Id public long id;

    private String titulo;

    @Backlink
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

    public List<Lista> getListas() {
        return listas.getListFactory().createList();
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

