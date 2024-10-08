package com.produto.serviceproduto.controller;

import com.produto.serviceproduto.data.request.ProdutoRequest;
import com.produto.serviceproduto.model.ProdutoEntity;
import com.produto.serviceproduto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")

public class ProdutoController implements ProdutoControllerInterface {

    private ProdutoService _produtoService;

    public ProdutoController(ProdutoService _produtoService) {
        this._produtoService = _produtoService;
    }

    @PostMapping    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ProdutoEntity Cadastrar(@Valid @RequestBody ProdutoRequest produto){

        ProdutoEntity produtoEntity = new ProdutoEntity(produto.getDescricao(), produto.getPreco());

        return _produtoService.inserir(produtoEntity);
    }

    @GetMapping("{id}")
    @Override
    public ProdutoEntity Consultar(@PathVariable("id") long id){

        return _produtoService.consultar(id);
    }
}
