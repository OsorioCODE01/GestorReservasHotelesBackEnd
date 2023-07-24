package com.reservashotel.model.repository;


import com.reservashotel.model.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRespository  extends JpaRepository<ClienteEntity, Long>{

    @Modifying
    @Query(value = "DELETE FROM RESERVAS_CLIENTES WHERE CLIENTES_ID_CLIENTE = :idCliente", nativeQuery = true)
    void elimnarClienteDeReservas(Long idCliente);

    @Modifying
    @Query(value = "DELETE FROM RESERVAS WHERE ID_CLIENTE = :idCliente",nativeQuery = true)
    void elimnarReservasConElCliente (Long idCliente);

    @Modifying
    @Query(value = "DELETE FROM CLIENTE WHERE ID_CLIENTE = :idCliente",nativeQuery = true)
    void eliminarCliente(Long idCliente);

}
