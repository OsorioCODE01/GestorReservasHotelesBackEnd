package com.reservashotel.service.implementations;

import com.reservashotel.model.entities.HabitacionEntity;
import com.reservashotel.model.entities.HotelEntity;
import com.reservashotel.model.repository.HabitacionRespository;
import com.reservashotel.model.repository.HotelRespository;
import com.reservashotel.service.interfaces.HabitacionService;
import com.reservashotel.web.dto.HabitacionDTO;
import com.reservashotel.web.exceptions.types.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitacionServiceImpl implements HabitacionService {


    @Autowired
    private HabitacionRespository habitacionRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HotelRespository hotelRespository;

    @Override
    public HabitacionDTO crearHabitacion(HabitacionDTO habitacionDTO) {
        HabitacionEntity habitacionEntity = modelMapper.map(habitacionDTO, HabitacionEntity.class);
        habitacionEntity = habitacionRespository.save(habitacionEntity);

        HotelEntity hotelEntity = hotelRespository.findById(habitacionDTO.getIdHotel().getIdHotel())
                .orElseThrow(()-> new BadRequestException("No se econtro un hotel con la id: "+habitacionDTO.getIdHotel().getIdHotel()));

        hotelEntity.agregarHabitacion(habitacionEntity);
        hotelRespository.save(hotelEntity);

        return modelMapper.map(habitacionEntity, HabitacionDTO.class);
    }

    @Override
    public HabitacionDTO obtenerHabitacion(Long idHabitacion) {
        HabitacionEntity habitacionEntity = habitacionRespository
                .findById(idHabitacion)
                .orElseThrow(() -> new BadRequestException("No se encontró una habitacion con el id: "+ idHabitacion));
        return modelMapper.map(habitacionEntity, HabitacionDTO.class);
    }

    @Override
    public List<HabitacionDTO> habitacionesPorHotel(Long idhotel) {
        List<HabitacionEntity> habitaciones = habitacionRespository.findByIdHotel(idhotel);
        return habitaciones.stream()
                .map(habitacionEntity -> modelMapper.map(habitacionEntity, HabitacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HabitacionDTO> allHabitaciones() {
        List<HabitacionEntity> habitacionEntities = habitacionRespository.findAll();
        return habitacionEntities.stream()
                .map(habitacionEntity -> modelMapper.map(habitacionEntity, HabitacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HabitacionDTO editarHabitacion(Long idHabitacion, HabitacionDTO habitacionDTO) {
        HabitacionEntity habitacionEntity = habitacionRespository.findById(idHabitacion)
                .orElseThrow(()-> new BadRequestException("No se econtró una habitacion con la id: "+idHabitacion));
        BeanUtils.copyProperties(habitacionDTO, habitacionEntity, "idHabitacion");
        habitacionEntity = habitacionRespository.save(habitacionEntity);
        return modelMapper.map(habitacionEntity, HabitacionDTO.class);
    }

    @Override
    public HabitacionDTO borrarHabitacion(Long idHabitacion) {
        HabitacionEntity habitacionEntity =habitacionRespository.findById(idHabitacion)
                .orElseThrow(()-> new BadRequestException("No se econtró una habitacion con la id: "+idHabitacion));
        habitacionRespository.delete(habitacionEntity);

        HotelEntity hotelEntity = hotelRespository.findById(habitacionEntity.getHotel().getIdHotel())
                .orElseThrow(()-> new BadRequestException("No se econtro un hotel con la id: "+habitacionEntity.getHotel().getIdHotel()));

        hotelEntity.actualizarNumhabitaciones();

        return modelMapper.map(habitacionEntity, HabitacionDTO.class);
    }
}
