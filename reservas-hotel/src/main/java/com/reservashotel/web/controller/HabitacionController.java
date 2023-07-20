package com.reservashotel.web.controller;

import com.reservashotel.service.interfaces.HabitacionService;
import com.reservashotel.web.dto.HabitacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apiHabitacion")
public class HabitacionController {
    @Autowired
    private HabitacionService habitacionService;

    @PostMapping("crearHabitacion")
    public ResponseEntity<HabitacionDTO> crearHabtiacion (@RequestBody HabitacionDTO habitacionDTO){
        return  new ResponseEntity<>(habitacionService.crearHabitacion(habitacionDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerHabitacion")
    public ResponseEntity<HabitacionDTO> obtenerHabitacion(@RequestParam("idHabitacion") Long idHabitacion){
        return new ResponseEntity<>(habitacionService.obtenerHabitacion(idHabitacion), HttpStatus.FOUND);
    }

    @GetMapping("habitacionesPorHotel")
    public ResponseEntity<List<HabitacionDTO>> habitacionesPorHotel(@RequestParam("idHotel") Long idhotel){
        return new ResponseEntity<>(habitacionService.habitacionesPorHotel(idhotel),HttpStatus.FOUND);
    }

    @GetMapping("allHabitaciones")
    public ResponseEntity<List<HabitacionDTO>> allHabitaciones(){
        return new ResponseEntity<>(habitacionService.allHabitaciones(),HttpStatus.FOUND);
    }

    @PutMapping("editarHabtiacion")
    public ResponseEntity<HabitacionDTO> editarHabitacion(@RequestParam("idHabitacion") Long idHabitacion, @RequestBody HabitacionDTO habitacionDTO){
        return new ResponseEntity<>(habitacionService.editarHabitacion(idHabitacion, habitacionDTO),HttpStatus.FOUND);
    }

    @DeleteMapping("borrarHabitacion")
    public ResponseEntity<HabitacionDTO> borrarHabitacion(@RequestParam("idHabitacion") Long idHabitacion){
        return new ResponseEntity<>(habitacionService.borrarHabitacion(idHabitacion),HttpStatus.FOUND);
    }
}
