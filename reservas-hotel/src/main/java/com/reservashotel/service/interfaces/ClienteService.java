package com.reservashotel.service.interfaces;


import com.reservashotel.model.entities.ClienteEntity;
import com.reservashotel.web.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO obtenerCliente(Long idCliente);

    ClienteDTO editarCliente(Long idCliente, ClienteDTO clienteDTO);

    ClienteDTO eliminarCliente(Long idCliente);

    List<ClienteDTO> obtenerClientes();
}
