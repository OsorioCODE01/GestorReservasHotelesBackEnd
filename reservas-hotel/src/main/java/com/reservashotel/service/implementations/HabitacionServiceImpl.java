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
        //Validaciones de la informacion que viene en HabitacionDTO
        if(habitacionDTO.getIdHotel() == null  || habitacionDTO.getNumHabitacion().isEmpty()) throw new BadRequestException("No se pueden omitir datos de la habitacion");
        if(habitacionDTO.getStatus() == null) habitacionDTO.setStatus(false);
        HabitacionEntity habitacionEntity = modelMapper.map(habitacionDTO, HabitacionEntity.class);

        //Verficacion de que no halla sido añadida previamente al hotel.
        List<HabitacionEntity> habitacionesHotel = habitacionRespository.findByIdHotel(habitacionDTO.getIdHotel().getIdHotel());
        for (HabitacionEntity habitacion : habitacionesHotel) {
            if (habitacion.getNumHabitacion().equals(habitacionDTO.getNumHabitacion())) {
                throw new BadRequestException("La habitación ya existe en el hotel.");
            }
        }

        habitacionEntity = habitacionRespository.save(habitacionEntity); //Se guarda habitacion en la base de datos

        HotelEntity hotelEntity = hotelRespository.findById(habitacionDTO.getIdHotel().getIdHotel()) //Busco el hotel en cual añadir habitaciones
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
