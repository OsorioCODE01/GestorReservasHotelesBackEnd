package com.reservashotel.service.interfaces;

import com.reservashotel.web.dto.ReservaDTO;

public interface ReservaService {
     ReservaDTO crearReserva(ReservaDTO reservaDTO);

     ReservaDTO obtenerReserva(Long idReserva);
}
