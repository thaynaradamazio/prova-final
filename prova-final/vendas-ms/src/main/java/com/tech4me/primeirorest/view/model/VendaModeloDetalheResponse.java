package com.tech4me.primeirorest.view.model;

public class VendaModeloDetalheResponse {
    private String id;
    private String codigoVenda;
    private List<ProdutoDTO> produtos;

    //#region Get / Set
    public String getId() {
        return id;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
    //#endregion

    public String getCodigoVendaCompleto() {
        return String.format("%s", codigoVenda);
    }
}
