/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.repository;

import com.reto3g12.reto3g12grupo5.entity.Reservation;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jorge
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
    public List<Reservation> findAllByStatus (String status);
    
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();
    
    @Query("SELECT r FROM Reservation r WHERE startDate BETWEEN ?1 AND ?2")
    List<Reservation> dateReservation(Calendar inicio, Calendar fin);
}
