package com.vedruna.api_1_n.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedruna.api_1_n.dto.JugadorDTO;
import com.vedruna.api_1_n.persistance.models.Jugador;
import java.util.List;


public interface JugadorRepository extends JpaRepository<Jugador, Long>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    
    List<Jugador> findByNombreJugador(String nombreJugador);
    List<Jugador> findByEdad(Integer edad);
    void save(JugadorDTO jugador);
    void deleteById(Long id);
}
