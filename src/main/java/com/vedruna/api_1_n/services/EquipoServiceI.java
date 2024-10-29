package com.vedruna.api_1_n.services;

import java.util.List;

import com.vedruna.api_1_n.dto.EquipoDTO;
import com.vedruna.api_1_n.persistance.models.Equipo;

public interface EquipoServiceI {
    
    List<EquipoDTO> getAllEquipos();
    List<EquipoDTO> getEquipoByNombre(String nombre);
    Equipo getEquipoById(Long id);
    void insertEquipo(EquipoDTO equipo);
    void saveEquipo(EquipoDTO equipo);
    void updateEquipo(Long id, EquipoDTO equipo);
    void deleteEquipo(Long id);
}
