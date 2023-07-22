package com.reservashotel.web.controller;

import com.reservashotel.service.interfaces.ReservaService;
import com.reservashotel.web.dto.ReservaDTO;
import com.reservashotel.web.dto.response.ReservaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ReservaResponse> obtenerReserva(@RequestParam("idReserva") Long idReserva){
        return new ResponseEntity<>(reservaService.obtenerReserva(idReserva),HttpStatus.OK);
    }

    @GetMapping("obtenerReservas")
    public ResponseEntity<List<ReservaResponse>> obtenerReservas(){
        return new ResponseEntity<>(reservaService.obtenerReservas(), HttpStatus.OK);
    }
    @GetMapping("obtenerReservasPorCliente")
    public ResponseEntity<List<ReservaResponse>> obtenerReservasPorCliente(@RequestParam("idCliente") Long idCliente){
        return new ResponseEntity<>(reservaService.obtenerReservasPorCliente(idCliente), HttpStatus.OK);
    }

    @GetMapping("obtenerReservasPorHotel")
    public ResponseEntity<List<ReservaResponse>> obtenerReservasPorHotel(@RequestParam("idHotel") Long idHotel){
        return new ResponseEntity<>(reservaService.obtenerReservasPorHotel(idHotel), HttpStatus.OK);
    }

    @GetMapping("ObtenerReservaPorHotelyCliente")
    public ResponseEntity<ReservaResponse> ObtenerReservaPorHotelyCliente(@RequestParam("idCliente") Long idCliente, @RequestParam("idHotel") Long idHotel){
        return new ResponseEntity<>(reservaService.ObtenerReservaPorHotelyCliente(idCliente, idHotel), HttpStatus.OK);
    }

    @PutMapping("editarReserva")
    public ResponseEntity<ReservaResponse> editarReserva(@RequestParam("idReserva") Long idReserva,
                                                         @RequestParam("tipo") Integer tipo,
                                                         @RequestParam("idObjeto") Long idObjeto,
                                                         @RequestBody ReservaDTO infoNueva){
        return new ResponseEntity<>(reservaService.editarReserva(idReserva, tipo, idObjeto, infoNueva), HttpStatus.OK);
    }

    @DeleteMapping("borrarReserva")
    public ResponseEntity<ReservaDTO> borrarReserva(@RequestParam("idReserva") Long idReserva){
        return new ResponseEntity<>(reservaService.borrarReserva(idReserva), HttpStatus.OK);
    }
}
