package com.reservashotel.model.entities;

import lombok.*;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name= "reservas")
public class ReservaEntity implements Serializable {

    @EmbeddedId
    private ReservaPK idReserva;

    @Column(name = "num_habitaciones")
    private Integer numHabitaciones;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_fin")
    private String fechaFin;


}
