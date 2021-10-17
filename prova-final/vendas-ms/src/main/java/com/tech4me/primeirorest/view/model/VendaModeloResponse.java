package com.tech4me.primeirorest.view.model;

public class VendaModeloResponse {
    private String id;
    private String codigoVenda;

    //#region Get / Set
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

    //#endregion

    public String getCodigoVenda() {
        return String.format("%s", codigoVenda);
    }
}
