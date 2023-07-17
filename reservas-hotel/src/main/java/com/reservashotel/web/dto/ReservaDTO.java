package com.reservashotel.web.dto;

import com.reservashotel.model.entities.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private Integer idCliente;

    private Integer idHotel;

    private List<String> habitaciones;

    private Integer numHabitaciones;

    private List<ClienteDTO> clientes;

    private Date fechaInicio;

    private Date fechaFin;
}
