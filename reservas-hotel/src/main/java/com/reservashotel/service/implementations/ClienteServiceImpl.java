package com.reservashotel.service.implementations;


import com.reservashotel.model.entities.ClienteEntity;
import com.reservashotel.model.repository.ClienteRespository;
import com.reservashotel.service.interfaces.ClienteService;
import com.reservashotel.web.dto.ClienteDTO;

import com.reservashotel.web.exceptions.types.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl  implements ClienteService {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        if(clienteRespository.existsById(clienteDTO.getIdCliente())) throw new BadRequestException("El usuario ya se encuentra registrado.");
        if(clienteDTO.getIdCliente().describeConstable().isEmpty()) throw new BadRequestException("La id no puede estar vacia");
        if(clienteDTO.getNombre().isEmpty()) throw new BadRequestException("El nombre no puede estar vacio");
        if(clienteDTO.getTipoDocumento().isEmpty()) throw new BadRequestException("Debe especificarse un tipo de documento");
        if(clienteDTO.getTelefono().isEmpty()) throw new BadRequestException("Telefono no puede estar vacio");
        if(clienteDTO.getCorreo().isEmpty()) throw new BadRequestException("El correo no debe esta vacio");
        if(clienteDTO.getContrasena().isEmpty()) throw new BadRequestException("Debe ingresar una contraseña");

        ClienteEntity clienteEntity = modelMapper.map(clienteDTO, ClienteEntity.class);
        clienteEntity = clienteRespository.save(clienteEntity);
        return modelMapper.map(clienteEntity, ClienteDTO.class);
    }


    @Override
    public ClienteDTO obtenerCliente(Long idCliente) {
        ClienteEntity clienteEntity = clienteRespository.findById(idCliente).
                orElseThrow(()-> new BadRequestException("no de econtro un cliente con la id: " + idCliente));
        return modelMapper.map(clienteEntity, ClienteDTO.class);
    }


    @Override
    public ClienteDTO editarCliente(Long idCliente, ClienteDTO nuevaInformacion) {

        ClienteEntity clienteEntity = clienteRespository.findById(idCliente).
                orElseThrow(()-> new BadRequestException("no de econtro un cliente con la id: " + idCliente));
        BeanUtils.copyProperties(nuevaInformacion, clienteEntity, "idCliente");
        clienteEntity = clienteRespository.save(clienteEntity);
        return modelMapper.map(clienteEntity, ClienteDTO.class);
    }

    @Override
    public ClienteDTO eliminarCliente(Long idCliente) {
        ClienteEntity clienteEntity = clienteRespository.findById(idCliente).
                orElseThrow(()-> new BadRequestException("no de econtro un cliente con la id: " + idCliente));

        clienteRespository.delete(clienteEntity);

        return modelMapper.map(clienteEntity, ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> obtenerClientes() {
        List<ClienteEntity> clientes = clienteRespository.findAll();
        return clientes.stream()
                .map(clienteEntity -> modelMapper.map(clienteEntity, ClienteDTO.class))
                .collect(Collectors.toList());
    }
}
