package com.reservashotel.service.interfaces;


import com.reservashotel.web.dto.HotelDTO;

public interface HotelService {
    HotelDTO crearHotel(HotelDTO hotelDTO);

    HotelDTO obtenerHotel(Integer idHotel);
}
