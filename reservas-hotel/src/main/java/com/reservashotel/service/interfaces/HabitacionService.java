package com.reservashotel.service.interfaces;

import com.reservashotel.web.dto.HabitacionDTO;

import java.util.List;

public interface HabitacionService {
    HabitacionDTO crearHabitacion(HabitacionDTO habitacionDTO);

    HabitacionDTO obtenerHabitacion(Long idHabitacion);

    List<HabitacionDTO> habitacionesPorHotel(Long idhotel);

    List<HabitacionDTO> allHabitaciones();

    HabitacionDTO editarHabitacion(Long idHabitacion, HabitacionDTO habitacionDTO);

    HabitacionDTO borrarHabitacion(Long idHabitacion);
}
