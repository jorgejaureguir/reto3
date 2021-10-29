/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.controller;

import com.reto3g12.reto3g12grupo5.entity.CountClients;
import com.reto3g12.reto3g12grupo5.entity.Reservation;
import com.reto3g12.reto3g12grupo5.entity.StatusReservation;
import com.reto3g12.reto3g12grupo5.service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService service;
    
    @GetMapping("/all")
    public List<Reservation> findAllProducto(){
        return service.getReservations();
    }
    
    @GetMapping("/{id}")    
    public Reservation findReservationsId(@PathVariable int id){
        return service.getReservationById(id);
    }
    
     @GetMapping("/report-clients")
    public List<CountClients> getReservationsReportsClient(){
        return service.getTopClients();
    }
    
    @GetMapping("/report-status")
    public StatusReservation getReservationsStatusReport(){
       
        List<Reservation>completed=service.getReservationStatus("completed");
        List<Reservation>cancelled=service.getReservationStatus("cancelled");
        StatusReservation report  = new StatusReservation(completed.size(), cancelled.size());
        return report;
       
    }
    
    @GetMapping("/report-dates/{inicio}/{fin}")    
    public List<Reservation> findReservationsId(@PathVariable String inicio,@PathVariable String fin){
         Calendar c1 = Calendar.getInstance();
         Calendar c2 = Calendar.getInstance();
        try {
            //return service.dateReservation(inicio, fin);
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            c1.setTime(in.parse(inicio));
            SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd");
            c2.setTime(fn.parse(fin));
                        
        } catch (ParseException ex) {
           // Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return service.dateReservation(c1, c2);
    }
    
    @PostMapping("/save")
    public ResponseEntity addReservation(@RequestBody Reservation reservation ){
        service.saveReservation(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateReservation(@RequestBody Reservation reservation){
        service.updateReservation(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping(path ="/{id}")
    public ResponseEntity deleteReservation(@PathVariable int id){
        service.deleteReservation(id);
        return ResponseEntity.status(204).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteReservation(@RequestBody Reservation reservation){
        service.deleteReservation(reservation.getIdReservation());
        return ResponseEntity.status(204).build();
    }
    
    
}
