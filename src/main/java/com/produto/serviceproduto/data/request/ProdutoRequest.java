package com.produto.serviceproduto.data.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotEmpty
    public String descricao;
    @NotNull
    public double preco;

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}
