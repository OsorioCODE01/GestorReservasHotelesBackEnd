package com.reservashotel.service.interfaces;


import com.reservashotel.web.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO obtenerCliente(Integer idCliente);
}
