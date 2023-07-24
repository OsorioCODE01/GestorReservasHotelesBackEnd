package com.reservashotel.service.implementations;



import com.reservashotel.model.entities.HabitacionEntity;
import com.reservashotel.model.entities.HotelEntity;
import com.reservashotel.model.entities.ReservaEntity;
import com.reservashotel.model.repository.HotelRespository;
import com.reservashotel.model.repository.ReservaRepository;
import com.reservashotel.service.interfaces.HotelService;
import com.reservashotel.web.dto.HotelDTO;
import com.reservashotel.web.dto.response.HotelResponse;
import com.reservashotel.web.exceptions.types.BadRequestException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl  implements HotelService {

    @Autowired
    private HotelRespository hotelRespository;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private ReservaRepository reservaRepository;


    @Override
    public HotelDTO crearHotel(HotelDTO hotelDTO) {
        if(hotelDTO.getIdHotel().describeConstable().isEmpty() ||
                hotelDTO.getCorreo().isEmpty() ||
                hotelDTO.getNombre().isEmpty() ||
                hotelDTO.getTelefono().isEmpty()
        ) throw new BadRequestException("No se pueden omitir campos del hotel.");

        HotelEntity hotelEntity = modelMapper.map(hotelDTO, HotelEntity.class);
        hotelEntity = hotelRespository.save(hotelEntity);
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public HotelResponse obtenerHotel(Long idHotel) {
        HotelEntity hotelEntity = hotelRespository.findById(idHotel).
                orElseThrow(()-> new BadRequestException("No se econtro un hotel con la id: " + idHotel));
        hotelEntity.actualizarNumhabitaciones();
        return modelMapper.map(hotelEntity, HotelResponse.class);
    }

    @Override
    public HotelDTO editarHotel(Long idHotel, HotelDTO nuevaInformacion) {
        HotelEntity hotelEntity = hotelRespository.findById(idHotel).
                orElseThrow(()->new BadRequestException("No se econtro un hotel con la id: " + idHotel));
        BeanUtils.copyProperties(nuevaInformacion, hotelEntity);
        hotelEntity = hotelRespository.save(hotelEntity);
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    @Override
    public List<HotelResponse> obtenerHoteles() {
        List<HotelEntity> hotelEntities = hotelRespository.findAll();
        return hotelEntities.stream().
                map(hotelEntity -> modelMapper.map(hotelEntity, HotelResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HotelDTO borrarHotel(Long idHotel) {
        HotelEntity hotelEntity = hotelRespository.findById(idHotel).orElseThrow(()-> new BadRequestException("no se econtro un hotel con la id: " +idHotel));

        List<ReservaEntity> reservasAsociadas = reservaRepository.findByIdHotel(idHotel).orElse(new ArrayList<>());

        for (ReservaEntity reserva : reservasAsociadas){
            reservaRepository.borrarHabitacionesDeLasReservas(reserva.getIdReserva());
        }
        hotelRespository.eliminarReservasConElHotel(idHotel);
        hotelRespository.eliminarHabitacionesDelHotel(idHotel);
        hotelRespository.delete(hotelEntity);
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }
}
