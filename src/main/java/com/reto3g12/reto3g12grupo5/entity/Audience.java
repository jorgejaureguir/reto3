/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="audience")
public class Audience implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",nullable=true,length=45,unique=false)
    private String name;
    @Column(name="owner",nullable=true,length=45,unique=false)
    private String owner;
    private int capacity;
    @Column(name="description",nullable=true,length=250,unique=false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("audiences")
    private Category category;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Message> messages;
    
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Reservation> reservations;
}
