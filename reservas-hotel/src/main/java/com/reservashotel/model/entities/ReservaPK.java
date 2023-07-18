package com.reservashotel.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaPK {

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "id_hotel")
    private Long idHotel;

}


