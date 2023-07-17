package com.reservashotel.service.implementations;

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
        return null;
    }

    @Override
    public ReservaDTO obtenerReserva(Long idReserva) {
        return null;
    }
}
