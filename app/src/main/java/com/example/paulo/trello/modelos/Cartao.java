package com.example.paulo.trello.modelos;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

@Entity
class Cartao {

    @Id long id ;
    private ToOne<Lista> lista;
    private String titulo;
    private String descricao;
    private ToMany<Comentario> comentarios;

    public Cartao () {}

    public Cartao (String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public ToOne<Lista> getLista() {
        return lista;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ToMany<Comentario> getComentarios() {
        return comentarios;
    }

    public void addComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public boolean removeComentario(long id) {
        if (this.comentarios.removeById(id) != null){
            return true;
        }
        return false;
    }
}
