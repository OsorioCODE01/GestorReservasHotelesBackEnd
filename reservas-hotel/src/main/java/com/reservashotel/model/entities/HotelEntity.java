package com.reservashotel.model.entities;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "hotel")
public class HotelEntity {
    @Id
    private Long idHotel;

    private String nombre;

    private String telefono;

    private String correo;

    private List<Integer> habitaciones;

    private String numHabitaciones;

}
