package com.reservashotel.service.implementations;


import com.reservashotel.model.repository.ClienteRespository;
import com.reservashotel.service.interfaces.ClienteService;
import com.reservashotel.web.dto.ClienteDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl  implements ClienteService {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        return null;
    }

    @Override
    public ClienteDTO obtenerCliente(Integer idCliente) {
        return null;
    }
}
