package com.produto.serviceproduto.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity(name = "tb_produto")

public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double preco;

    public ProdutoEntity(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Deprecated
    public ProdutoEntity() {

    }

    public Long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ProdutoEntity that = (ProdutoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
