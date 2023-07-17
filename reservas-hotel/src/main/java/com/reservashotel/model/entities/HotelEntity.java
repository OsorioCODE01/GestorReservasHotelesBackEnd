package com.reservashotel.model.entities;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHotel;

    private String nombre;

    private String telefono;

    private String correo;

    private List<String> habitaciones;

    private String numHabitaciones;

}
