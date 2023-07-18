package com.reservashotel.service.implementations;

import com.reservashotel.model.entities.ReservaEntity;
import com.reservashotel.model.entities.ReservaPK;
import com.reservashotel.model.repository.ReservaRepository;
import com.reservashotel.service.interfaces.ReservaService;
import com.reservashotel.web.dto.ReservaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {


    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ReservaDTO crearReserva(ReservaDTO reservaDTO) {
        ReservaEntity reservaEntity = modelMapper.map(reservaDTO, ReservaEntity.class);
        reservaEntity.setIdReserva(new ReservaPK(reservaDTO.getIdCliente(), reservaDTO.getIdHotel()));
        reservaEntity = reservaRepository.save(reservaEntity);
        return modelMapper.map(reservaEntity, ReservaDTO.class);
    }

    @Override
    public ReservaDTO obtenerReserva(Long idReserva) {
        return null;
    }
}
