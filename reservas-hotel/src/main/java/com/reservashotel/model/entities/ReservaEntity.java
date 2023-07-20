package com.reservashotel.model.entities;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name= "reservas")
public class ReservaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_Hotel")
    private HotelEntity idHotel;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity idCliente;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "fecha_fin")
    private String fechaFin;

    @ManyToMany
    private List<ClienteEntity> clientes;

    @OneToMany
    private List<HabitacionEntity> habitaciones;


    @Column(name = "num_habitaciones")
    private Integer numHabitaciones;

    public void agregarCliente(ClienteEntity cliente){
        clientes.add(cliente);
    }
    public void quitarCliente(ClienteEntity cliente){
        clientes.remove(cliente);
    }

    public void agregarHabitacion(HabitacionEntity habitacion){
        habitacion.setStatus(true);
        habitaciones.add(habitacion);
        numHabitaciones = habitaciones.size();
    }
    public void quitarHabitacion (HabitacionEntity habitacion){
        habitacion.setStatus(false);
        habitaciones.remove(habitacion);
        numHabitaciones = habitaciones.size();
    }


}
