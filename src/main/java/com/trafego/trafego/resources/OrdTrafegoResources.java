/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.resources;

import com.trafego.trafego.entities.OrdTrafego;
import com.trafego.trafego.repository.OrdTrafegoRepository;
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
@RequestMapping("ordstrafego")
@CrossOrigin({"*"})
public class OrdTrafegoResources {
    
    @Autowired
    OrdTrafegoRepository ordTrafegoRepository;
    
    @GetMapping
    public List<OrdTrafego> listarOrdsTrafego(){
        return ordTrafegoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public OrdTrafego listarOrdTrafegoUnico(@PathVariable(value="id") Long id){
        return ordTrafegoRepository.findById(id).get();
    }
    
    @PostMapping
    public OrdTrafego salvarOrdTrafego(@RequestBody OrdTrafego ordTrafego){
        return ordTrafegoRepository.save(ordTrafego);
    }
    
    @DeleteMapping("/{id}")
    public List<OrdTrafego> deletarOrdTrafego(@PathVariable(value="id") Long id){
        ordTrafegoRepository.deleteById(id);
        return ordTrafegoRepository.findAll();
    }
    
    @PutMapping
    public OrdTrafego atualizarOrdTrafego(@RequestBody OrdTrafego ordTrafego){
        return ordTrafegoRepository.saveAndFlush(ordTrafego);
    }
    
    //Consulta Ordens de Tráfego pelo Condutor
    @GetMapping("/condutor/{nome}")
    public List<OrdTrafego> pesquisaOrdTrafCondutor(@PathVariable String nome) {
        return ordTrafegoRepository.porCondutor(nome);
    }

    //Consulta Ordens de Tráfego pelo Trajeto
    @GetMapping("/trajeto/{origem}/{destino}")
    public List<OrdTrafego> pesquisaOrdTrafTrajeto(@PathVariable String origem, @PathVariable String destino) {
        return ordTrafegoRepository.porTrajeto(origem, destino);
    }

    //Consulta Ordens de Tráfego pela Data
    @GetMapping("/data/{inicio}")
    public List<OrdTrafego> pesquisaOrdTrafData(@PathVariable String inicio) {
        return  ordTrafegoRepository.porData(inicio);
    }

    //Consulta Ordens de Tráfego pelo Veículo
    @GetMapping("/veiculo/{placa}")
    public List<OrdTrafego> pesquisaOrdTrafVeiculo(@PathVariable String placa) {
        return ordTrafegoRepository.porVeiculo(placa);
    }
    
    //Consulta Ordens de Tráfego pela Quilometragem
    @GetMapping("/km/{menor}/{maior}")
    public List<OrdTrafego> pesquisaOrdTrafKm(@PathVariable float menor, @PathVariable float maior) {
        return ordTrafegoRepository.porQuilometragem(menor, maior);
    }

}
