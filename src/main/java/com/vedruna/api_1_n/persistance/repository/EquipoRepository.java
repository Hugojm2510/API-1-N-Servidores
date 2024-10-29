package com.vedruna.api_1_n.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.api_1_n.dto.EquipoDTO;
import com.vedruna.api_1_n.persistance.models.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    
    List<Equipo> findByNombre(String nombre);
    void save(EquipoDTO equipo);
}
