package com.vedruna.api_1_n.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.api_1_n.dto.JugadorDTO;
import com.vedruna.api_1_n.persistance.models.Equipo;
import com.vedruna.api_1_n.persistance.models.Jugador;
import com.vedruna.api_1_n.persistance.repository.JugadorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class JugadorServiceImpI implements JugadorServiceI{
    
    @Autowired
    JugadorRepository jRepo;

    @Autowired
    EquipoServiceI equipoMngmnt;

    @PersistenceContext
    private EntityManager entity;

    @Override
    public List<JugadorDTO> getAllJugadores(){
        List<Jugador> jugadores = jRepo.findAll();
        List<JugadorDTO> jugadorDTOs = new ArrayList<>();

        for (Jugador jugador : jugadores){
            JugadorDTO jugadorDTO = new JugadorDTO();
            jugadorDTO.setJugadorId(jugador.getJugadorId());
            jugadorDTO.setNombreJugador(jugador.getNombreJugador());
            jugadorDTO.setEdad(jugador.getEdad());

            if (jugador.getEquipo() != null) {
                jugadorDTO.setEquipos_idequipo(jugador.getEquipo().getEquipoId());
            } else {
                jugadorDTO.setEquipos_idequipo(null);
            }

            jugadorDTOs.add(jugadorDTO);
        }

        return jugadorDTOs;
    }


    @Override
    public void inscribirJugador(Long jugadorId, Long equipoId){
        Jugador jugador = entity.find(Jugador.class, equipoId);
        Equipo equipo = equipoMngmnt.getEquipoById(equipoId);

        if (equipo != null){
            jugador.setEquipo(equipo);
            jRepo.save(jugador);
        } else {
            System.out.println("Equipo no encontrado");
        }

    }

    @Override
    public void insertarJugador(JugadorDTO jugador){
        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setJugadorId(jugador.getJugadorId());
        nuevoJugador.setNombreJugador(jugador.getNombreJugador());
        nuevoJugador.setEdad(jugador.getEdad());

        Equipo equipo = equipoMngmnt.getEquipoById(jugador.getEquipos_idequipo());

        if (equipo != null) {
            nuevoJugador.setEquipo(equipo);
            jRepo.save(nuevoJugador);    
        } else {
            System.out.println("equipo con " + jugador.getEquipos_idequipo() + " no existe");
        }     
    }

    @Override
    public List<JugadorDTO> getJugadorByNombreJugador(String nombreJugador){
        List<Jugador> jugadorList = jRepo.findByNombreJugador(nombreJugador);
        List<JugadorDTO> jugadorDTOList = new ArrayList<>();

        for (Jugador equipo : jugadorList) {
            jugadorDTOList.add(new JugadorDTO(equipo));
        }

        return jugadorDTOList;
    }

    @Override
    public void saveJugador(JugadorDTO jugador){
        jRepo.save(jugador);
    }

    @Override
    public void updateJugador(Long id, JugadorDTO jugador){
        jugador.setJugadorId(id);
        jRepo.save(jugador);
    }

    @Override
    public void deleteJugador(Long id){
        jRepo.deleteById(id);
    }
}
