package com.tech4me.produtosms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.InputMismatchException;

@Document
public class Produto {
    @Id
    private String id;
    private String comprador;
    private String nome;
    private Integer numerosCodigo;
    private String letrasCodigo;
    private Boolean emEstoque;
    private int valorDoProduto;
    private int QuantidadeEmEstoque;

    public Produto() {
        setEmEstoque(true);
    }

    public Produto(String Codigo, String nome) {
    setCodigo(Codigo);
    this.nome = nome;
}

public Produto() {
}

//#region Get / Set

public String getCodigo() {
    if(letrasCodigo == null) {
        return letrasCodigo;
    } else {
        return letrasCodigo + numerosCodigo;
    }
}

public void setCodigo(String codigo) {
    if(codigo != null && codigo.matches("[A-Z]{3}\\d{4}")) {
        letrasCodigo = codigo.substring(0, 3);
        numerosCodigo = Integer.parseInt(codigo.substring(3));
    } else {
        throw new InputMismatchException("O código precisa ter 3 letras e 4 números, as letras devem ser maiúsculas");
    } 
}

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
