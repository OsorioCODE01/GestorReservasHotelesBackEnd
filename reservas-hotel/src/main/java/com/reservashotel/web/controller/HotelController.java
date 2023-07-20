package com.reservashotel.web.controller;

import com.reservashotel.model.repository.HotelRespository;
import com.reservashotel.service.interfaces.HotelService;
import com.reservashotel.web.dto.HotelDTO;
import com.reservashotel.web.dto.response.HotelResponse;
import com.reservashotel.web.exceptions.types.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apiHotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRespository hotelRespository;

    @PostMapping("crearHotel")
    public ResponseEntity<HotelDTO> crearHotel (@RequestBody HotelDTO hotelDTO){
        if(hotelRespository.existsById(hotelDTO.getIdHotel())) throw new BadRequestException("El hotel ya se ecuentra registrado.");
        return new ResponseEntity<>(hotelService.crearHotel(hotelDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerHotel")
    public ResponseEntity<HotelResponse> obtenerHotel(@RequestParam("idHotel") Long idHotel){
        return new ResponseEntity<>(hotelService.obtenerHotel(idHotel),HttpStatus.FOUND);
    }

    @GetMapping("obtenerHoteles")
    public ResponseEntity<List<HotelResponse>> obtenerHoteles(){
        return new ResponseEntity<>(hotelService.obtenerHoteles(),HttpStatus.FOUND);
    }

    @PutMapping("editarHotel")
    public ResponseEntity<HotelDTO> editarHotel(@RequestParam("idHotel") Long idHotel, @RequestBody HotelDTO hotelDTO){
        return new ResponseEntity<>(hotelService.editarHotel(idHotel, hotelDTO), HttpStatus.FOUND);
    }

    @DeleteMapping("borrarHotel")
    public ResponseEntity<HotelDTO> borrarHotel(@RequestParam("idHotel") Long idHotel){
        return new ResponseEntity<>(hotelService.borrarHotel(idHotel), HttpStatus.FOUND);
    }
}