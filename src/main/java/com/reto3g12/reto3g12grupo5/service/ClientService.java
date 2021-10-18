/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;

import com.reto3g12.reto3g12grupo5.entity.Client;
import com.reto3g12.reto3g12grupo5.repository.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    
    /**C
     * Nuevo producto
     */    
    public Client saveProducto(Client client){
        return repository.save(client);
    }
    /**R
     * Mostrar todos los productos
     */
    public List<Client> getClients(){
        return  repository.findAll();
    }
    /**U
     * Actualizar registros productos
     */
    public Client updateClient(Client client){
        Client existeClient = repository.findById(client.getIdClient()).orElse(null);
        existeClient.setEmail(client.getEmail());
        existeClient.setPassword(client.getPassword());
        existeClient.setName(client.getName());
        existeClient.setAge(client.getAge());
        repository.save(existeClient);
        return existeClient;
    }
    /**
     * D
     * Eliminar Registro de la tabla producto
     * 
     */
    
    public String deleteClient(int id){   
        repository.deleteById(id);
        return "Client Removido "+id;        
    }

}
