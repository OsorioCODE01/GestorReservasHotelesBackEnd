package com.reservashotel.model.repository;

import com.reservashotel.model.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    @Query(value = "SELECT * FROM reservas WHERE ID_HOTEL= :idHotel", nativeQuery = true)
  Optional<List<ReservaEntity> >   findByIdHotel(Long idHotel);

    @Query(value = "SELECT * FROM reservas WHERE ID_CLIENTE= :idCliente", nativeQuery = true)
    Optional<List<ReservaEntity>>  findByIdCliente(Long idCliente);

    @Query(value = "SELECT * FROM reservas WHERE ID_CLIENTE= :idCliente AND ID_HOTEL= :idHotel", nativeQuery = true)
   Optional<ReservaEntity>  findByHotelAndCliente (Long idCliente, Long idHotel);

    @Modifying
    @Query(value = "DELETE FROM RESERVAS_HABITACIONES WHERE RESERVA_ENTITY_ID_RESERVA = :idReserva  ",nativeQuery = true)
    void borrarHabitacionesDeLasReservas(Long idReserva);
}


