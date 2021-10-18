/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="audience_id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Audience audience;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;  
}
    