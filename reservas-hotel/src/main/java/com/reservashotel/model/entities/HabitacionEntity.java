package com.reservashotel.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "habitaciones")
public class HabitacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHabitacion;

    private String numHabitacion;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelEntity hotel;

    private Boolean status;

}
