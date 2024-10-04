package com.produto.serviceproduto.controller;

import com.produto.serviceproduto.data.request.ProdutoRequest;
import com.produto.serviceproduto.data.response.ProdutoResponse;
import com.produto.serviceproduto.model.ProdutoEntity;
import com.produto.serviceproduto.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")

public class ProdutoController {

    private ProdutoService _produtoService;
    @Autowired
    private ModelMapper _modelMapper;

    public ProdutoController(ProdutoService _produtoService, ModelMapper _modelMapper) {
        this._produtoService = _produtoService;
        this._modelMapper = _modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse Cadastrar(@RequestBody ProdutoRequest produto)
    {
        ProdutoEntity produtoEntity = new ProdutoEntity(produto.descricao(), produto.preco());

        ProdutoEntity inserirProduto = _produtoService.inserir(produtoEntity);

        return _modelMapper.map(inserirProduto, ProdutoResponse.class);

    }

    @GetMapping("{id}")
    public ProdutoResponse Consultar(@PathVariable("id") long id){

        ProdutoEntity consultarProduto = _produtoService.consultar(id);

        return _modelMapper.map(consultarProduto, ProdutoResponse.class);
    }
}
