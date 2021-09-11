/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trafego.trafego.repository;

import com.trafego.trafego.entities.OrdTrafego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laerton
 */
@Repository
public interface OrdTrafegoRepository extends JpaRepository<OrdTrafego, Long> {

    //Buscar Ordem de Trafego pelo Condutor
    @Query("select ot from OrdTrafego ot where ot.condutor.nome = :nome")
    List<OrdTrafego> porCondutor(String nome);

    //Buscar Ordem Trafego por Veiculo
    @Query("select ot from OrdTrafego ot where ot.veiculo.num_placa = ?1")
    List<OrdTrafego> porVeiculo(String num_placa);

    //Buscar Ordem de trafego pela Data
    @Query("select ot from OrdTrafego ot where ot.dt_viagem like :dt_inicio")
    List<OrdTrafego> porData(@Param("dt_inicio") String dt_inicio);

    //Buscar Ordem de Trafego pelo Trajeto
    @Query("select ot from OrdTrafego ot where ot.origem like :origem% and ot.destino like :destino%")
    List<OrdTrafego> porTrajeto(@Param("origem") String origem, @Param("destino") String destino);

    //Buscar Ordem de Trafego pela Quilometragem
    @Query("select ot from OrdTrafego ot where ot.distancia >= :menor and ot.distancia <= :maior")
    List<OrdTrafego> porQuilometragem(@Param("menor") float menor, @Param("maior") float maior);

    
}
