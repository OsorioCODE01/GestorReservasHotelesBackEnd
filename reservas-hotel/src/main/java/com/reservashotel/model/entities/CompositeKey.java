package com.reservashotel.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CompositeKey implements Serializable {
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name="idHotel")
    private Integer idHotel;

}
