package com.reservashotel.service.interfaces;


import com.reservashotel.web.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO crearHotel(HotelDTO hotelDTO);

    HotelDTO obtenerHotel(Long idHotel);

    HotelDTO editarHotel(Long idHotel, HotelDTO hotelDTO);

    List<HotelDTO> obtenerHoteles();

    HotelDTO borrarHotel(Long idHotel);
}
