/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.entity;
/**
 * se importan las librerias
 */
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
 * @author Jorge Jauregui
 * 
 */

/**
 * 
 * Hacemos uso de la depemdecias para crear la tablas, constructores y metodos
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="audience")
/**
 * 
 * Se declara la clase
 * 
 */
public class Audience implements Serializable{
    /**
     * 
     * se crea un id auto incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Se declara la variable name con los parametros solicitados
     */
    @Column(name="name",nullable=true,length=45,unique=false)
    private String name;
    /**
     * Se declara la variable owner con los parametros solicitados
     */
    @Column(name="owner",nullable=true,length=45,unique=false)
    private String owner;
    /**
     * Se declara la variable capacity con los parametros solicitados
     */
    private int capacity;
    /**
     * e declara la variable description con los parametros solicitados
     */
    @Column(name="description",nullable=true,length=250,unique=false)
    private String description;
    /**
     * Se establece la relacion muchos a uno categorias
     * 
     */
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("audiences")
    private Category category;
    /**
     * Se establece la relacion uno a muchos mensajes
     * 
     */
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Message> messages;
    /**
     * se establce la relacion uno a muchos reservaciones
     */
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Reservation> reservations;
}
