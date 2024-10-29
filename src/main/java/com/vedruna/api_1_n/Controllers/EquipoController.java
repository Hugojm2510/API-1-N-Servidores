package com.vedruna.api_1_n.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.api_1_n.dto.EquipoDTO;
import com.vedruna.api_1_n.persistance.models.Equipo;
import com.vedruna.api_1_n.services.EquipoServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/equipo")
@CrossOrigin
public class EquipoController {
    
    @Autowired
    EquipoServiceI equipoMngmnt;

    @GetMapping
    public List<EquipoDTO> verEquipos() {
        return equipoMngmnt.getAllEquipos();
    }

    @GetMapping("name/{nombre}")
    public List<EquipoDTO> getMethodName(@PathVariable String nombre) {
        List<EquipoDTO> equipos = equipoMngmnt.getEquipoByNombre(nombre);
        return equipos;
    }

    @PostMapping("/insert")
    public void insertarJugador(@RequestBody EquipoDTO equipo) {
        equipoMngmnt.insertEquipo(equipo);
    }

    @PutMapping("/edit/{id}")
    public void editEquipo(@PathVariable Long id, @RequestBody EquipoDTO equipo) {
        Equipo equipoExiste = equipoMngmnt.getEquipoById(id);

        equipoExiste.setNombre(equipo.getNombre());

        equipoMngmnt.updateEquipo(id, equipo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEquipo(@PathVariable Long id){
           equipoMngmnt.deleteEquipo(id);
    }

    
}
