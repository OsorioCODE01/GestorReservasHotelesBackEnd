package com.reservashotel.model.repository;


import com.reservashotel.model.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository  extends JpaRepository<ClienteEntity, Long>{

}
