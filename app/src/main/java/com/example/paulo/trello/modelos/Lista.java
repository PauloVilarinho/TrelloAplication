package com.example.paulo.trello.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
class Lista {

    @Id long id;
    private ToOne<Quadro> quadro;
    private String titulo;
    private ToMany<Cartao> cartoes;


    public Lista () {}

    public Lista (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ToMany<Cartao> getCartoes() {
        return cartoes;
    }

    public void addCartao(Cartao cartao){
        this.cartoes.add(cartao);
    }

    public boolean removeCartao(long id){
        if (this.cartoes.removeById(id) != null){
            return true;
        }
        return false;
    }

    public ToOne<Quadro> getQuadro() {
        return quadro;
    }
}
