package com.reservashotel.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.security.PublicKey;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "cliente")
public class ClienteEntity {
    @Id
    private Long idCliente;

    private String tipoDocumento;

    private String nombre;

    private String telefono;

    private String correo;

    private String contrasena;

    private Boolean nivel;

}
