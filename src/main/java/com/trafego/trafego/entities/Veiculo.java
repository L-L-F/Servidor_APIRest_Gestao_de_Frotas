/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author laerton
 */
@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String num_placa;
    private String ano_fab;
    private String descricao;
    private float qtd_km; 
    
    @Enumerated(EnumType.STRING)
    private EnumEstConservacao est_conserv;
    @Enumerated(EnumType.STRING)
    private  EnumCategoria caegoria;
      
    @Embedded
    private Marca marca;
    @Embedded
    private Modelo modelo;
    
    @JsonIgnore
    @OneToMany(mappedBy = "veiculo")
    private List<OrdTrafego> ord_traf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum_placa() {
        return num_placa;
    }

    public void setNum_placa(String num_placa) {
        this.num_placa = num_placa;
    }

    public String getAno_fab() {
        return ano_fab;
    }

    public void setAno_fab(String ano_fab) {
        this.ano_fab = ano_fab;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQtd_km() {
        return qtd_km;
    }

    public void setQtd_km(float qtd_km) {
        this.qtd_km = qtd_km;
    }

    public EnumEstConservacao getEst_conserv() {
        return est_conserv;
    }

    public void setEst_conserv(EnumEstConservacao est_conserv) {
        this.est_conserv = est_conserv;
    }

    public EnumCategoria getCaegoria() {
        return caegoria;
    }

    public void setCaegoria(EnumCategoria caegoria) {
        this.caegoria = caegoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<OrdTrafego> getOrd_traf() {
        return ord_traf;
    }

    public void setOrd_traf(List<OrdTrafego> ord_traf) {
        this.ord_traf = ord_traf;
    }

    
}
