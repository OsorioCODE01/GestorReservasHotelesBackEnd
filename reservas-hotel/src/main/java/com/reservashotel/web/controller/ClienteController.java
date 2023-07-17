package com.reservashotel.web.controller;

import com.reservashotel.service.interfaces.ClienteService;
import com.reservashotel.web.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("apiCliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("crearCliente")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.crearCliente(clienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerCliente")
    public ResponseEntity<ClienteDTO> obtenerCliente (@RequestParam("idCliente") Integer idCliente){
        return new ResponseEntity<>(clienteService.obtenerCliente(idCliente), HttpStatus.FOUND);
    }

}
