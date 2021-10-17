package com.tech4me.produtosms.view.model;

public class ProdutoModeloResponse {
    private String id;
    private String comprador;
    private String nome;
    private Integer numerosCodigo;
    private String letrasCodigo;
    private Boolean emEstoque;

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
    //#endregion
}
