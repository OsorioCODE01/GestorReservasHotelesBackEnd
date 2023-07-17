package com.reservashotel.model.repository;


import com.reservashotel.model.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRespository extends JpaRepository<HotelEntity, Integer> {
}
