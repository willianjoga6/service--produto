package com.produto.serviceproduto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import produto.Produto;

@RestController
@RequestMapping("produto")

public class ProdutoController {

    @PostMapping
    public Produto Cadastrar(@RequestBody Produto produto)
    {
        return produto;
    }
}
