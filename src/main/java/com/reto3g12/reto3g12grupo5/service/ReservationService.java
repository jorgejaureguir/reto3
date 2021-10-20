/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;

import com.reto3g12.reto3g12grupo5.entity.Reservation;
import com.reto3g12.reto3g12grupo5.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;
    
    /**C
     * Nuevo reservacion
     */    
    public Reservation saveReservation(Reservation reservation){
        return repository.save(reservation);
    }
    /**R
     * Mostrar todas los reservaciones
     */
    public List<Reservation> getReservations(){
        return  repository.findAll();
    }
    /**U
     * Actualizar registros reservaciones
     */
    public Reservation updateReservation(Reservation reservation){
        Reservation existeReservation = repository.findById(reservation.getIdReservation()).orElse(null);
        existeReservation.setStartDate(reservation.getStartDate());
        existeReservation.setDevolutionDate(reservation.getDevolutionDate());
        existeReservation.setStatus(reservation.getStatus());
        repository.save(existeReservation);
        return existeReservation;
    }
    /**
     * D
     * Eliminar Registro de la tabla producto
     * 
     */
    
    public String deleteReservation(int id){   
        repository.deleteById(id);
        return "Reservation Removido "+id;        
    }

}
