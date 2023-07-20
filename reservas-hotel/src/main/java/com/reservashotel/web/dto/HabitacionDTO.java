package com.reservashotel.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HabitacionDTO {

     private Long idHabitacion;

     private String numHabitacion;

     private HotelDTO idHotel;

     private Boolean status;
}
