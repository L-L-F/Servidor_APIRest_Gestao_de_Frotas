/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.resources;

import com.trafego.trafego.entities.EnumEstConservacao;
import com.trafego.trafego.entities.Marca;
import com.trafego.trafego.entities.Modelo;
import com.trafego.trafego.entities.Veiculo;
import com.trafego.trafego.repository.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author laerton
 */
@RestController
@RequestMapping("veiculos")
@CrossOrigin({"*"})
public class VeiculoResources {
   
    @Autowired
    VeiculoRepository veiculoRepository;
    
    @GetMapping
    public List<Veiculo> listarVeiculos(){
        return veiculoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Veiculo listarVeiculo(@PathVariable(value="id") Long id){
        return veiculoRepository.findById(id).get();
    }
    
    @PostMapping
    public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo, Marca marca, Modelo modelo){
        return veiculoRepository.save(veiculo);
    }
    
    @DeleteMapping("/{id}")
    public List<Veiculo> deletarVeiculo(@PathVariable(value="id") Long id){
         veiculoRepository.deleteById(id);
         return veiculoRepository.findAll();
    }
    
    @PutMapping
    public Veiculo atualizarVeiculo(@RequestBody Veiculo veiculo){
        return veiculoRepository.saveAndFlush(veiculo);
    }
    
    //Consulta Veículos pela marca
    @GetMapping("/marca/{marca}")
    public List<Veiculo> pesquisarMarca(@PathVariable String marca) {
        return veiculoRepository.porMarca(marca);
    }

    //Consulta Veículo pelo modelo
    @GetMapping("/modelo/{modelo}")
    public List<Veiculo> pesquisarModelo(@PathVariable String modelo) {
        return  veiculoRepository.porModelo(modelo);
    }

    //Consulta Veículos pelo estado de conservação
    @GetMapping("/estado/{conservacao}")
    public List<Veiculo> pesquisarEstConservacao(@PathVariable String conservacao) {
        return veiculoRepository.porEstConservacao(EnumEstConservacao.valueOf(conservacao));
    }

    //Consultar Veículos pela quilometragem
    @GetMapping("/km/{menor}/{maior}")
    public List<Veiculo> pesquisarQuilometragem(@PathVariable float menor, @PathVariable float maior) {
        return veiculoRepository.porQuilometragem(menor, maior);
    }
    
}
