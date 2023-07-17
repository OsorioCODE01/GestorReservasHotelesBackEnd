package com.reservashotel.model.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name= "reservas")
public class ReservaEntity {

    @Id
    private Long idReserva;

    @ManyToOne
    private ClienteEntity cliente;

    @ManyToOne
    private HotelEntity hotel;

    private List<Integer> habitaciones;

    private Integer numHabitaciones;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ClienteEntity> clientes;

    private Date fechaInicio;

    private Date fechaFin;


}
