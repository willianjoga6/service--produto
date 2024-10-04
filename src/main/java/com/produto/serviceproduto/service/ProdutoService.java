package com.produto.serviceproduto.service;

import com.produto.serviceproduto.model.ProdutoEntity;

public interface ProdutoService {
    ProdutoEntity inserir(ProdutoEntity produto);
    ProdutoEntity consultar(long id);
}
