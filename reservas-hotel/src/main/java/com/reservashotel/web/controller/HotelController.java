package com.reservashotel.web.controller;

import com.reservashotel.service.interfaces.HotelService;
import com.reservashotel.web.dto.HotelDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiHotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("crearHotel")
    public ResponseEntity<HotelDTO> crearHotel (@RequestBody HotelDTO hotelDTO){
        return new ResponseEntity<>(hotelService.crearHotel(hotelDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerHotel")
    public ResponseEntity<HotelDTO> obtenerHotel(@RequestParam("idHotel") Integer idHotel){
        return new ResponseEntity<>(hotelService.obtenerHotel(idHotel),HttpStatus.FOUND);
    }
}