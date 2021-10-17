package com.tech4me.primeirorest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech4me.primeirorest.compartilhado.VendaDto;
import com.tech4me.primeirorest.http.ProdutosFeignClient;
import com.tech4me.primeirorest.model.Venda;
import com.tech4me.primeirorest.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository repo;

    @Autowired
    private ProdutosFeignClient produtosFeignClient;

    @Override
    public VendaDto criarVenda(VendaDto venda) {
        return salvarVenda(venda);
    }

    @Override
    public List<VendaDto> obterTodos() {
        List<Venda> vendas = repo.findAll();

        return vendas.stream()
            .map(venda -> new ModelMapper().map(venda, VendaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
       Optional<Venda> venda = repo.findById(id);

       if(venda.isPresent()) {

           VendaDto dto = new ModelMapper().map(venda.get(), VendaDto.class);
           
           //Aqui vou ir no meu serviço de produtos para pegar a lista de produtos dessa pessoa
           List<ProdutoDTO> produtos = produtosFeignClient.obterProdutos(dto.getId());

           //Aqui estou salvando a lista de produtos no meu objeto venda
           dto.setProdutos(produtos);

           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public void removerVenda(String id) {
        repo.deleteById(id);
    }

    @Override
    public VendaDto atualizarVenda(String id, VendaDto venda) {
        venda.setId(id);
        return salvarVenda(venda);
    }

    private VendaDto salvarVenda(VendaDto venda) {
        ModelMapper mapper = new ModelMapper();
        Venda vendaEntidade = mapper.map(venda, Venda.class);
        vendaEntidade = repo.save(vendaEntidade);

        return mapper.map(vendaEntidade, VendaDto.class);
    }
}
