/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;

import com.reto3g12.reto3g12grupo5.entity.Client;
import com.reto3g12.reto3g12grupo5.entity.CountClients;
import com.reto3g12.reto3g12grupo5.entity.Reservation;
import com.reto3g12.reto3g12grupo5.repository.ReservationRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
/**
 * Se declara la clase
 */
public class ReservationService {
    /**
     * se declara una variable de tipo ReservationRepository
     */
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
     * Eliminar Registro de la tabla reservacion
     * 
     */
    
    public String deleteReservation(int id){   
        repository.deleteById(id);
        return "Reservation Removido "+id;        
    }
    
    
    public Reservation getReservationById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public List<Reservation> dateReservation(Calendar inicio,Calendar fin){
        return repository.dateReservation(inicio, fin);
   }
    
     public List<Reservation> getReservationStatus(String status){
        return repository.findAllByStatus(status);
    }
    
    public List<CountClients> getTopClients(){
       List<CountClients> res= new ArrayList<>();
       List<Object[]> report = repository.countTotalReservationByClient();
       for(int i=0;i<report.size();i++){
           res.add(new CountClients((Long)report.get(i)[1],(Client) report.get(i)[0]));
       }
       return res;
   } 
}
