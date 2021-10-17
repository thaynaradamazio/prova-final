package com.tech4me.produtosms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech4me.produtosms.compartilhado.ProdutoDto;
import com.tech4me.produtosms.model.Produto;
import com.tech4me.produtosms.repository.ProdutoRepositorio;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepositorio repo;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        return salvarProduto(produto);
    }

    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repo.findAll();

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repo.findById(id);

       if(produto.isPresent()) {
           return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
       }

       return Optional.empty();
    }

    @Override
    public List<ProdutoDto> obterPorComprador(String comprador) {
        List<Produto> produtos = repo.findByComprador(comprador);

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void removerProduto(String id) {
        repo.deleteById(id);
    }

    @Override
    public boolean definirComoMorto(String id) {
        Optional<Produto> produto = repo.findById(id);
        if(produto.isPresent()) {
            produto.get().setEmEstoque(false);
            repo.save(produto.get());

            return true;
        }

        return false;
    }

    @Override
    public ProdutoDto atualizarProduto(String id, ProdutoDto produto) {
        produto.setId(id);
        return salvarProduto(produto);
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = repo.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }
    
}
