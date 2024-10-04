package com.produto.serviceproduto.data.response;

import java.util.Objects;

public class ErroResponse {
    public String codigo;
    public String mensagem;
    public String documentacao;

    public ErroResponse(String codigo, String mensagem, String documentacao) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
        this.documentacao = documentacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDocumentacao() {
        return documentacao;
    }
}
