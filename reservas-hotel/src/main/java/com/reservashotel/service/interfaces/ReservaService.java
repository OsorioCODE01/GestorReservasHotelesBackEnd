package com.reservashotel.service.interfaces;

import com.reservashotel.web.dto.ReservaDTO;
import com.reservashotel.web.dto.response.ReservaResponse;

import java.util.List;

public interface ReservaService {
     ReservaDTO crearReserva(ReservaDTO reservaDTO);

     ReservaResponse obtenerReserva(Long idReserva);

     List<ReservaResponse> obtenerReservas();

     ReservaResponse editarReserva(Long idReserva, Integer tipo, Long idObjeto, ReservaDTO infoNueva);

     ReservaDTO borrarReserva(Long idReserva);
}
