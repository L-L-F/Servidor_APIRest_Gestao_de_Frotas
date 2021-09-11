/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.repository;

import com.trafego.trafego.entities.Condutor;
import com.trafego.trafego.entities.EnumGenero;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laerton
 */
@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long>{
    
    //Buscar Condutor pelo Nome
    @Query("select c from Condutor c where c.nome like ?1")
    List<Condutor> porNome(String nome);
    
    //Buscar Condutor pelo CPF
    @Query("select c from Condutor c where c.cpf = :cpf")
    Condutor porCPF(String cpf);
    
    //Buscar Condutor pelo Genero
    @Query("select c from Condutor c where c.genero = :genero")
    List<Condutor> porGenero(EnumGenero genero);

    //Buscar Condutor pela CNH
    @Query("select c from Condutor c where c.cnh.numCnh = :cnh")
    Condutor porCNH(Long cnh);

    //Buscar Condutores pela categoria da CNH
    @Query("select c from Condutor c where c.cnh.categoria = :categoria")
    List<Condutor> porCatCNH(String categoria);

    
}
