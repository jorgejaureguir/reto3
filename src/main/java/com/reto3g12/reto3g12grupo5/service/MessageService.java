/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;

import com.reto3g12.reto3g12grupo5.entity.Message;
import com.reto3g12.reto3g12grupo5.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    /**C
     * Nuevo message
     */
    public Message saveMessage(Message message){
        return repository.save(message);
    }
    /**r
     * Mostrar todos los mensajes
     */
    public List<Message> getMessages(){
        return repository.findAll();   
    }
    /**U
     * Actualizar registros
     */
    public Message updateMessage(Message message){
        Message existeMessage = repository.findById(message.getId()).orElse(null);
        existeMessage.setMessageText(message.getMessageText());
        repository.save(existeMessage);
        return existeMessage;
    }
    /**
     * D
     * Eliminar Registro de la tabla message
     * 
     */
    public String deleteMessage(int id){   
        repository.deleteById(id);
        return "Message Removido "+id;        
    }
}
