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

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HabitacionEntity> habitaciones;

    @Column(name = "num_habitaciones")
    private Integer numHabitaciones;

    public void agregarHabitacion(HabitacionEntity habitacion){
        habitaciones.add(habitacion);
        numHabitaciones = habitaciones.size();
    }
    public void actualizarNumhabitaciones(){
        numHabitaciones = habitaciones.size();
    }

}
