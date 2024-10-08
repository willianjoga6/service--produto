package com.produto.serviceproduto.data.response;

import org.springframework.lang.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;

public class ErroResponse {
    public String codigo;
    public String mensagem;
    public String documentacao;

    public ErroResponse(String codigo, String mensagem, @NonNull String urlDocumentation) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        this.documentacao = url + urlDocumentation;
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
