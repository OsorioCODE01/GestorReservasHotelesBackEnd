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
    private Long idHotel;

    private String nombre;

    private String telefono;

    private  String correo;

    private List<Integer> habitaciones;

    private String numHabitaciones;

}
