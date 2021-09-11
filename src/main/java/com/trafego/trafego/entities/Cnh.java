/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author laerton
 */
@Embeddable
public class Cnh implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long numCnh;
    private String categoria;
    private String validade;
    private String obs;

    public Long getNumCnh() {
        return numCnh;
    }

    public void setNumCnh(Long numCnh) {
        this.numCnh = numCnh;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    
    
}
