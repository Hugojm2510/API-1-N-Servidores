package com.vedruna.api_1_n.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vedruna.api_1_n.persistance.models.Equipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipoDTO {

    private Long equipoId;
    private String nombre;
    private JugadorDTO jugador;

    public EquipoDTO(Equipo equipo){
        this.equipoId = equipo.getEquipoId();
        this.nombre = equipo.getNombre();
    }
    
}
