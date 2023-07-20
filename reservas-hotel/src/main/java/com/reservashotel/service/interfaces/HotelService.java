package com.reservashotel.service.interfaces;


import com.reservashotel.web.dto.HotelDTO;
import com.reservashotel.web.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {
    HotelDTO crearHotel(HotelDTO hotelDTO);

    HotelResponse obtenerHotel(Long idHotel);

    HotelDTO editarHotel(Long idHotel, HotelDTO hotelDTO);

    List<HotelResponse> obtenerHoteles();

    HotelDTO borrarHotel(Long idHotel);
}
