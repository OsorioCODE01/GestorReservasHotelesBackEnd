package com.reservashotel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClienteDTO {
    private Long idCliente;

    private String tipoDocumento;

    private String nombre;

    private String telefono;

    private String correo;

    private String contrasena;

    private Boolean nivel;

}
