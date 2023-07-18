package com.reservashotel.web.dto.response;

import com.reservashotel.web.dto.HabitacionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponse {
    private Long idHotel;

    private String nombre;

    private String telefono;

    private  String correo;

    private List<HabitacionDTO> habitaciones;

    private Integer numHabitaciones;

}
