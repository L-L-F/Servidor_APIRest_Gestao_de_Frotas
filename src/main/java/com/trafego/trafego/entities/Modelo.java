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
public class Modelo implements Serializable {

    private String nomeModelo;

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

}
