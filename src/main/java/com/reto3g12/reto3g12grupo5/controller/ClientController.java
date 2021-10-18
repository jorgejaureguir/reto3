/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.controller;

import com.reto3g12.reto3g12grupo5.entity.Client;
import com.reto3g12.reto3g12grupo5.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping("api/Client")
public class ClientController {
    @Autowired
    private ClientService service;
    
    @GetMapping("/all")
    public List<Client> findAllProducto(){
        return service.getClients();
    }
    
    @PostMapping("/save")
    public ResponseEntity addClient(@RequestBody Client client ){
        service.saveProducto(client);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client){
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteClient(@RequestBody Client client){
        service.deleteClient(client.getIdClient());
        return ResponseEntity.status(204).build();
    }
}
