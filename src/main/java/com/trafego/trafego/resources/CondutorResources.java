/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.resources;

import com.trafego.trafego.entities.Condutor;
import com.trafego.trafego.entities.EnumGenero;
import com.trafego.trafego.repository.CondutorRepository;
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
@RequestMapping("condutores")
@CrossOrigin({"*"})
public class CondutorResources {
    
    @Autowired
    CondutorRepository condutorRepository;
    
    @GetMapping
    public List<Condutor> listarCondutores(){
        return condutorRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Condutor listarCondutorUnico(@PathVariable(value="id") Long id){
        return condutorRepository.findById(id).get();
    }
    
    @PostMapping
    public Condutor salvarCondutor(@RequestBody Condutor condutor){
        return condutorRepository.save(condutor);
    }
    
    @DeleteMapping("/{id}")
    public List<Condutor> deletarCondutor(@PathVariable(value="id") Long id){
       condutorRepository.deleteById(id);
       return condutorRepository.findAll();     
    }
    
    @PutMapping
    public Condutor atualizarCondutor(@RequestBody Condutor condutor){
        return condutorRepository.saveAndFlush(condutor);
    }
    
    //Consultar Condutor pelo Nome
    @GetMapping("/nome/{nome}")
    public List<Condutor> pesquisaNome(@PathVariable String nome) {
        return condutorRepository.porNome(nome);
    }
    
    //Consultar Condutor por CPF
    @GetMapping("/cpf/{cpf}")
    public Condutor pesquisaCpf(@PathVariable String cpf) {
        return condutorRepository.porCPF(cpf);
    }

    //Consultar Condutores pelo Genero
    @GetMapping("/genero/{genero}")
    public List<Condutor> pesquisaGenero(@PathVariable String genero) {
        return condutorRepository.porGenero(EnumGenero.valueOf(genero));
    }
    
    //Consultar Condutores pela CNH
    @GetMapping("/cnh/{cnh}")
    public Condutor pesquisaCnh(@PathVariable Long cnh) {
        return condutorRepository.porCNH(cnh);
    }
    
    //Consultar Condutores pela Gategoria da CNH
    @GetMapping("/cnhcat/{catategoria}")
    public List<Condutor> pesquisaCnh(@PathVariable String categoria) {
        return condutorRepository.porCatCNH(categoria);
    }

}
