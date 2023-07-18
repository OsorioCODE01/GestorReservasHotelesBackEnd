package com.reservashotel.model.repository;

import com.reservashotel.model.entities.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitacionRespository extends JpaRepository<HabitacionEntity, Long> {

    @Query(value = "SELECT * FROM habitaciones WHERE ID_HOTEL= :idHotel", nativeQuery = true)
    List<HabitacionEntity>  findByIdHotel(Long idHotel);

}
