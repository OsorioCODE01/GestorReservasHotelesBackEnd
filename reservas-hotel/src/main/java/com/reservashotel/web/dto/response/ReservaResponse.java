package com.reservashotel.web.dto.response;

import com.reservashotel.web.dto.ClienteDTO;
import com.reservashotel.web.dto.HabitacionDTO;
import com.reservashotel.web.dto.HotelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponse {

    private Long idReserva;

    private HotelDTO idHotel;

    private ClienteDTO idCliente;

    private String fechaInicio;

    private String fechaFin;

    private List<ClienteDTO> clientes;

    private List<HabitacionDTO> habitaciones;

    private Integer NumHabitaciones;


}
