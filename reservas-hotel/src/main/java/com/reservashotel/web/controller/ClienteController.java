package com.reservashotel.web.controller;

import com.reservashotel.model.repository.ClienteRespository;
import com.reservashotel.service.interfaces.ClienteService;
import com.reservashotel.web.dto.ClienteDTO;
import com.reservashotel.web.exceptions.types.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("apiCliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRespository clienteRespository;

    @PostMapping("crearCliente")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody ClienteDTO clienteDTO){
        if(clienteRespository.existsById(clienteDTO.getIdCliente())) throw new BadRequestException("El usuario ya se encuentra registrado.");
        return new ResponseEntity<>(clienteService.crearCliente(clienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerCliente")
    public ResponseEntity<ClienteDTO> obtenerCliente (@RequestParam("idCliente") Long idCliente){
        return new ResponseEntity<>(clienteService.obtenerCliente(idCliente), HttpStatus.FOUND);
    }

    @GetMapping("obtenerClientes")
    public ResponseEntity<List<ClienteDTO>> obtenerClientes(){
        return new ResponseEntity<>(clienteService.obtenerClientes(), HttpStatus.FOUND);
    }

    @PutMapping("editarCliente")
    public ResponseEntity<ClienteDTO> editarCliente(@RequestParam("idCliente") Long idCliente, @RequestBody ClienteDTO clienteDTO){
        return new ResponseEntity<>(clienteService.editarCliente(idCliente, clienteDTO), HttpStatus.FOUND);
    }

    @DeleteMapping("eliminarCliente")
    public ResponseEntity<ClienteDTO> eliminarCliente(@RequestParam("idCliente") Long idCliente){
        return new ResponseEntity<>(clienteService.eliminarCliente(idCliente), HttpStatus.FOUND);
    }

}
