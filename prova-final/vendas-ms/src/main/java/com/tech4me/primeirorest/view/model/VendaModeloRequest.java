package com.tech4me.primeirorest.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class VendaModeloRequest {
    @NotBlank(message = "O código da venda deve possuir caracteres não brancos")
    @NotEmpty(message = "O código da venda deve ser preenchido")
    @Size(min = 5, message = "O código da venda deve ter, no mínimo, 5 caracteres")
    private String codigoVenda;

    //#region Get / Set
    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    //#endregion
}
