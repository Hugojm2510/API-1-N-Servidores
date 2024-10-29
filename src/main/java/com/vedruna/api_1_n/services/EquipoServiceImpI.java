package com.vedruna.api_1_n.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.api_1_n.dto.EquipoDTO;
import com.vedruna.api_1_n.persistance.models.Equipo;
import com.vedruna.api_1_n.persistance.models.Jugador;
import com.vedruna.api_1_n.persistance.repository.EquipoRepository;
import com.vedruna.api_1_n.persistance.repository.JugadorRepository;

@Service
public class EquipoServiceImpI implements EquipoServiceI{

    @Autowired
    EquipoRepository eRepo;

    @Autowired
    JugadorRepository jRepo;

    @Override
    public List<EquipoDTO> getAllEquipos(){
        List<Equipo> docList = eRepo.findAll();
        List<EquipoDTO> docListDTO = new ArrayList<EquipoDTO>();

        for (Equipo equipo : docList){
            docListDTO.add(new EquipoDTO(equipo));
        }

        return docListDTO;
    }

    @Override
    public List<EquipoDTO> getEquipoByNombre(String nombre){
        List<Equipo> equipos = eRepo.findByNombre(nombre);
        List<EquipoDTO> equipoDTOList = new ArrayList<>();

        for (Equipo equipo : equipos){
            equipoDTOList.add(new EquipoDTO(equipo));
        }

        return equipoDTOList;
    }

    public Equipo getEquipoById(Long id){
        return eRepo.findById(id).orElse(null);
    }

    @Override
    public void insertEquipo(EquipoDTO equipo){
        Equipo nuevoEquipo = new Equipo();
        nuevoEquipo.setNombre(equipo.getNombre());

        if (equipo.getJugador() != null) {
            Jugador jugador = new Jugador();
            jugador.setNombreJugador(equipo.getJugador().getNombreJugador());
            jugador.setEdad(equipo.getJugador().getEdad());

            nuevoEquipo.addJugador(jugador);
            jugador.setEquipo(nuevoEquipo);
        }
        eRepo.save(nuevoEquipo);
    }
    
    @Override
    public void saveEquipo(EquipoDTO equipo){
        eRepo.save(equipo);
    }

    @Override
    public void updateEquipo(Long id, EquipoDTO equipo){
        eRepo.save(equipo);
    }

    @Override
    public void deleteEquipo(Long id){
        Equipo equipo = eRepo.findById(id).orElse(null);

        if(equipo != null){
            for(Jugador jugador : equipo.getJugadores()){
                jugador.setEquipo(null);
            }

        jRepo.saveAll(equipo.getJugadores());
        }

        eRepo.deleteById(id);
    }
}
