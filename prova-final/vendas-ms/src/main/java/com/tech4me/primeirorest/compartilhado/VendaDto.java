package com.tech4me.primeirorest.compartilhado;

import java.util.List;

public class VendaDto {
    private String id;
    private String codigoVenda;
    private List<ProdutoDTO> produtos;
    private Date data;
    public String produtoVendido;
    public int quantidadeVendida;
    public double valorProdutoVendido;
    
    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public String getId() {
        return id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date string) {
        this.data = string;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getValorProdutoVendido() {
        return valorProdutoVendido;
    }

    public void setValorProdutoVendido(double valorProdutoVendido) {
        this.valorProdutoVendido = valorProdutoVendido;
    }
    //#endregion
}
