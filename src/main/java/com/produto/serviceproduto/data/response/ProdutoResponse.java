package com.produto.serviceproduto.data.response;

import java.time.LocalDate;

public class ProdutoResponse {

    public  long id;
    public  String descricao;
    public final LocalDate data = LocalDate.now();

    @Deprecated
    public ProdutoResponse() {
    }

    public long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDate getData() {
        return data;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
