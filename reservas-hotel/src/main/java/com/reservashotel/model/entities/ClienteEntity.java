package com.reservashotel.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    private Integer idCliente;

    private String nombre;

    private String telefono;

    private String correo;

    private String contrasena;

    private Boolean nivel;

}
