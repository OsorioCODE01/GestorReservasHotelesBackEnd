package com.reservashotel.service.implementations;


import com.reservashotel.model.repository.HotelRespository;
import com.reservashotel.service.interfaces.HotelService;
import com.reservashotel.web.dto.HotelDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl  implements HotelService {

    @Autowired
    private HotelRespository hotelRespository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public HotelDTO crearHotel(HotelDTO hotelDTO) {
        return null;
    }

    @Override
    public HotelDTO obtenerHotel(Integer idHotel) {
        return null;
    }
}
