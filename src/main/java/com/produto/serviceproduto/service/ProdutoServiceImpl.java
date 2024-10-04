package com.produto.serviceproduto.service;

import com.produto.serviceproduto.model.ProdutoEntity;
import com.produto.serviceproduto.repository.ProdutoRepository;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository _produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository _produtoRepository) {
        this._produtoRepository = _produtoRepository;
    }

    @Override
    public ProdutoEntity inserir(ProdutoEntity produto) {
        return _produtoRepository.save(produto);
    }

    @Override
    public ProdutoEntity consultar(long id) {

        return _produtoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Produto de código %d não encontrado", id)));
    }
}
