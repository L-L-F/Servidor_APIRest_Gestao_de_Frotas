/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trafego.trafego.repository;

import com.trafego.trafego.entities.EnumEstConservacao;
import com.trafego.trafego.entities.Veiculo;
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
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
    //Busca Veiculo pela Marca
    @Query("select v from Veiculo v where v.marca.nomeMarca = :marca")
    List<Veiculo> porMarca(String marca);

    //Busca veiculo por Modelo
    @Query("select v from Veiculo v where v.modelo.nomeModelo like ?1")
    List<Veiculo> porModelo(String modelo);

    //Busca Veiculo pelo Estado de Conservação
    @Query("select v from Veiculo v where v.est_conserv = :conservacao")
    List<Veiculo> porEstConservacao(EnumEstConservacao conservacao);

    //Buscar Veículo pela Quilometragem
    @Query("select v from Veiculo v where v.qtd_km >= :menor and v.qtd_km <= :maior")
    List<Veiculo> porQuilometragem(@Param("menor") float menor, @Param("maior") float maior);
    
    /*
    @PersistenceContext
    private EntityManager em;
    
    //savar veiculo
    public void save(Veiculo veiculo){
        em.persist(veiculo);
    }
    
    //buscar um veículo pelo id
    public Veiculo veiculo(Long id) {
        return em.find(Veiculo.class, id);
    }
    
    //buscar lista de veículos
    @SuppressWarnings("unchecked")
    public List<Veiculo> veiculos(){
        Query query = em.createQuery("from Veiculo");
        return query.getResultList();
    }
    
    //remover um veiculo pelo id
    public void remove(Long id){
        Veiculo v = em.find(Veiculo.class, id);
        em.remove(v);
    }
    
    //editar e atualizar um veiculo
    public void update(Veiculo veiculo){
        em.merge(veiculo);
    }
    */
}
