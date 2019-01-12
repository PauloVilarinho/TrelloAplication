package com.example.paulo.trello.modelos;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Comentario {

    @Id long id;
    private ToOne<Cartao> cartao;
    private String comentario;

    public Comentario () {}

    public Comentario (String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ToOne<Cartao> getCartao() {
        return cartao;
    }
}
