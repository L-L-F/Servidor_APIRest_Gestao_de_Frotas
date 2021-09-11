/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author laerton
 */
@Embeddable
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String end;
    private String bairro;
    private String cep;
    private String estado;
    private String uf;

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
}
