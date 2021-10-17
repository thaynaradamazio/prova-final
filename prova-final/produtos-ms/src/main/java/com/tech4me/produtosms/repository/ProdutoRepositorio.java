package com.tech4me.produtosms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tech4me.produtosms.model.Animal;

@Repository
public interface ProdutoRepositorio extends MongoRepository<Produto, String> {

	List<Produto> findByComprador(String comprador);
    
}
