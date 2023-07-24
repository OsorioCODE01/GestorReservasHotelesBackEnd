package com.reservashotel.model.repository;


import com.reservashotel.model.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HotelRespository extends JpaRepository<HotelEntity, Long> {

    @Modifying
    @Query(value = "DELETE FROM HABITACIONES WHERE ID_HOTEL = :idHotel",nativeQuery = true)
    void eliminarHabitacionesDelHotel(Long idHotel);

    @Modifying
    @Query(value = "DELETE FROM RESERVAS WHERE ID_HOTEL = :idHotel", nativeQuery = true)
    void eliminarReservasConElHotel(Long idHotel);


}
