package com.reservashotel.service.implementations;

import com.reservashotel.model.entities.ClienteEntity;
import com.reservashotel.model.entities.HabitacionEntity;
import com.reservashotel.model.entities.ReservaEntity;
import com.reservashotel.model.repository.ClienteRespository;
import com.reservashotel.model.repository.HabitacionRespository;
import com.reservashotel.model.repository.ReservaRepository;
import com.reservashotel.service.interfaces.ReservaService;
import com.reservashotel.web.dto.ReservaDTO;
import com.reservashotel.web.dto.response.ReservaResponse;
import com.reservashotel.web.exceptions.types.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {


    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private HabitacionRespository habitacionRespository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ReservaDTO crearReserva(ReservaDTO reservaDTO) {

        if(reservaRepository.findByHotelAndCliente(reservaDTO.getIdCliente().getIdCliente(), reservaDTO.getIdHotel().getIdHotel()).isPresent()) {
            throw new BadRequestException("La reserva ya existe");
        }

        if (reservaDTO.getFechaFin().isEmpty() || reservaDTO.getFechaInicio().isEmpty()){
            throw new BadRequestException("No se pueden omitir las fechas de la reserva.");
        }
        if (reservaDTO.getIdCliente() == null || reservaDTO.getIdHotel() == null){
            throw new BadRequestException("No se pueden omitir los datos del hotel o el cliente.");
        }
        ReservaEntity reservaEntity = modelMapper.map(reservaDTO, ReservaEntity.class);
        reservaEntity = reservaRepository.save(reservaEntity);
        return modelMapper.map(reservaEntity, ReservaDTO.class);
    }

    @Override
    public ReservaResponse obtenerReserva(Long idReserva) {
        ReservaEntity reserva = reservaRepository.findById(idReserva)
                .orElseThrow(()->new BadRequestException("No se econtró niguna reserva con id: " + idReserva));
        return modelMapper.map(reserva, ReservaResponse.class);
    }

    @Override
    public List<ReservaResponse> obtenerReservas() {
        List<ReservaEntity> reservaEntities = reservaRepository.findAll();
        return reservaEntities.stream().
                map(reservaEntity -> modelMapper.map(reservaEntity, ReservaResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaResponse> obtenerReservasPorCliente(Long idCliente) {
        List<ReservaEntity> reservaEntities = reservaRepository.findByIdCliente(idCliente)
                .orElseThrow(()-> new BadRequestException("No se econtró reservasd con el cliente: "+ idCliente));
        return reservaEntities.stream().
                map(reserva -> modelMapper.map(reserva, ReservaResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaResponse> obtenerReservasPorHotel(Long idHotel) {
        List<ReservaEntity> reservaEntities = reservaRepository.findByIdHotel(idHotel)
                .orElseThrow(()-> new BadRequestException("No se econtró reservas en el hotel: " +idHotel));
        return reservaEntities.stream().
                map(reserva -> modelMapper.map(reserva, ReservaResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservaResponse ObtenerReservaPorHotelyCliente(Long idCliente, Long idHotel) {
        ReservaEntity reservaEntity = reservaRepository.findByHotelAndCliente(idCliente, idHotel)
                .orElseThrow(()-> new BadRequestException("No se econtró ninguna reserva con idHotel: "+ idHotel +" y idCliente: "+idCliente));
        return modelMapper.map(reservaEntity, ReservaResponse.class);
    }


    @Override
    public ReservaResponse editarReserva(Long idReserva, Integer tipo, Long idObjeto, ReservaDTO infoNueva) {
        ReservaEntity reservaEntity = reservaRepository.findById(idReserva)
                .orElseThrow(()-> new BadRequestException("No se econtró ninguna reserva con la id: " +idReserva));

        BeanUtils.copyProperties(infoNueva, reservaEntity,"idReserva");

        switch (tipo) {
            case 1 -> {
                ClienteEntity nuevoCliente = clienteRespository.findById(idObjeto)
                        .orElseThrow(() -> new BadRequestException("No se econtró ningun cliente con id: " + idObjeto));
             reservaEntity.getClientes().forEach(clienteEntity -> {
                 if (clienteEntity == nuevoCliente) {throw new BadRequestException("Ya se encuentra en la lista");

                 }
             });
                reservaEntity.agregarCliente(nuevoCliente);
            }
            case 2 -> {
                ClienteEntity fueraCliente = clienteRespository.findById(idObjeto)
                        .orElseThrow(() -> new BadRequestException("No se econtró ningun cliente con id: " + idObjeto));
                reservaEntity.quitarCliente(fueraCliente);
            }
            case 3 -> {
                HabitacionEntity nuevaHabitacion = habitacionRespository.findById(idObjeto)
                        .orElseThrow(() -> new BadRequestException("No se econtró ninguna habitacion con id: " + idObjeto));
                reservaEntity.getHabitaciones().forEach(habitacionEntity -> {
                    if(Objects.equals(habitacionEntity.getNumHabitacion(), nuevaHabitacion.getNumHabitacion()))throw new BadRequestException("Esa habitaicon ya ha sido añadida");

            });
                reservaEntity.agregarHabitacion(nuevaHabitacion);
            }
            case 4 -> {
                HabitacionEntity fueraHabitacion = habitacionRespository.findById(idObjeto)
                        .orElseThrow(() -> new BadRequestException("No se econtró ninguna habitacion con id: " + idObjeto));
                reservaEntity.quitarHabitacion(fueraHabitacion);
            }
        }
        reservaEntity = reservaRepository.save(reservaEntity);
        return modelMapper.map(reservaEntity, ReservaResponse.class);
    }


    @Override
    public ReservaDTO borrarReserva(Long idReserva) {
        ReservaEntity reservaEntity = reservaRepository.findById(idReserva)
                .orElseThrow(() -> new BadRequestException("No se econtró ninguna reserva con la id:" + idReserva));
        reservaRepository.delete(reservaEntity);
        return modelMapper.map(reservaEntity, ReservaDTO.class);
    }
}

