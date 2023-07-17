package com.reservashotel.web.controller;

import com.reservashotel.service.interfaces.ReservaService;
import com.reservashotel.web.dto.ReservaDTO;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiReserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("crearReserva")
    public ResponseEntity<ReservaDTO> crearReserva (@RequestBody ReservaDTO reservaDTO){
        return  new ResponseEntity<>(reservaService.crearReserva(reservaDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerReserva")
    public ResponseEntity<ReservaDTO> obtenerReserva(@RequestParam("idReserva") Long idReserva){
        return new ResponseEntity<>(reservaService.obtenerReserva(idReserva),HttpStatus.FOUND);
    }
}
