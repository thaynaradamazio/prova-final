package com.tech4me.produtosms.view.model;

public class ProdutoModeloInclusao {
    private String comprador;
    private String nome;
    private Integer numerosCodigo;
    private String letrasCodigo;

    //#region Get / Set
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

    public void setLetrasCodigo(String letrasCodigo) {
        this.letrasCodigo = letrasCodigo;
    }
    //#endregion
}
