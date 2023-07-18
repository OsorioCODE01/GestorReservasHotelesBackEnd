package com.reservashotel.web.dto;

import com.reservashotel.model.entities.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long idCliente;

    private Long idHotel;

    private String fechaInicio;

    private String fechaFin;
}
