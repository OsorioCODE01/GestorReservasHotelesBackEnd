package com.reservashotel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long idReserva;

    private HotelDTO idHotel;

    private ClienteDTO idCliente;

    private String fechaInicio;

    private String fechaFin;
}
