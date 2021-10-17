package com.tech4me.produtosms.compartilhado;

public class ProdutoDto {
    private String id;
    private String comprador;
    private String nome;
    private Integer numerosCodigo;
    private String letrasCodigo;
    private Boolean emEstoque;
    private int valorDoProduto;
    private int QuantidadeEmEstoque;

    //#region Get / Set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumerosCodigo() {
        return numerosCodigo;
    }

    public void setNumerosCodigo(Integer numerosCodigo) {
        this.numerosCodigo = numerosCodigo;
    }

    public String getLetrasCodigo() {
        return letrasCodigo;
    }

    public void setletrasCodigo(String letrasCodigo) {
        this.letrasCodigo = letrasCodigo;
    }

    public Boolean getEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(Boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public int getValorDoProduto() {
        return valorDoProduto;
    }

    public void setValorDoProduto(int valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }

    public int getQuantidadeEmEstoque() {
        return QuantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        QuantidadeEmEstoque = quantidadeEmEstoque;
    }
    //#endregion
}
