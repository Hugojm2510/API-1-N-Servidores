package com.vedruna.api_1_n.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.api_1_n.dto.JugadorDTO;
import com.vedruna.api_1_n.services.EquipoServiceI;
import com.vedruna.api_1_n.services.JugadorServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/jugador")
@CrossOrigin
public class JugadorController {
    
    @Autowired
    JugadorServiceI jugadorMngmnt;

    @GetMapping
    public List<JugadorDTO> getMethodName() {
        return jugadorMngmnt.getAllJugadores();
    }

    @GetMapping("name/{nombreJugador}")
    public List<JugadorDTO> getMethodName(@PathVariable String nombreJugador) {
        return jugadorMngmnt.getJugadorByNombreJugador(nombreJugador);
    }

    @PostMapping("/insert")
    public void insertarJugador(@RequestBody JugadorDTO jugador) {
        jugadorMngmnt.insertarJugador(jugador);
    }

    @PostMapping("/inscribir")
    public void inscribirJugador(@RequestBody Long jugadorId, @RequestParam Long equipoId) {        
        jugadorMngmnt.inscribirJugador(jugadorId, equipoId);
    }
    

    @PutMapping("/edit/{id}")
    public void editJugador(@PathVariable Long id, @RequestBody JugadorDTO jugador) {
        jugadorMngmnt.updateJugador(id, jugador);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteJugador(@PathVariable Long id){
        jugadorMngmnt.deleteJugador(id);
    }
    
    
    



}
