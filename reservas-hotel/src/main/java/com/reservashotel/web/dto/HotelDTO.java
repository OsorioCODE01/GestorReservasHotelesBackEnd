package com.reservashotel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private Integer idHotel;

    private String nombre;

    private String telefono;

    private  String correo;

    private List<String> habitaciones;

    private String numHabitaciones;

}
