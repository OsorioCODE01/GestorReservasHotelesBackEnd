package com.reservashotel.model.repository;

import com.reservashotel.model.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query(value = "SELECT * FROM reservas WHERE ID_HOTEL= :idHotel", nativeQuery = true)
    List<ReservaEntity> findByIdHotel(Long idHotel);

    @Query(value = "SELECT * FROM reservas WHERE ID_CLIENTE= :idCliente", nativeQuery = true)
    List<ReservaEntity> findByIdCliente(Long idCliente);
}

