package com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.produtosms.compartilhado.AnimalDto;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto produto);
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorId(String id);
    List<ProdutoDto> obterPorComprador(String comprador);
    void removerProduto(String id);
    boolean definirComoSemEstoque(String id);
    ProdutoDto atualizarProduto(String id, ProdutoDto produto);
}
