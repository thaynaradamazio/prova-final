package com.tech4me.primeirorest.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.primeirorest.compartilhado.VendaDto;

public interface VendaService {
    VendaDto criarVenda(VendaDto venda);
    List<VendaDto> obterTodos();
    Optional<VendaDto> obterPorId(String id);
    void removerVenda(String id);
    VendaDto atualizarVenda(String id, VendaDto venda);
}
