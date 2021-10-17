package com.tech4me.primeirorest.http;

import java.util.list;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tech4me.primeirorest.compartilhado.ProdutoDTO;

@FeignClient(name = "produtos-ms")
public interface ProdutosFeignClient {

    @GetMapping(path = "/api/produtos/{idComprador}/lista")
    List<ProdutoDTO> obterProdutos(@PathVariable String idComprador);
}