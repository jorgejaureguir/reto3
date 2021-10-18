/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.controller;

import com.reto3g12.reto3g12grupo5.entity.Message;
import com.reto3g12.reto3g12grupo5.service.MessageService;
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
@RequestMapping("/api/Message")
public class MessageControlloer {
    @Autowired
    private MessageService service;
    
    @GetMapping("/all")
    public List<Message> findAllMessage(){
        return service.getMessages();
    }
    
    @PostMapping("/save")
    public ResponseEntity addMessage(@RequestBody Message message ){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        service.updateMessage(message);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteMessage(@RequestBody Message message){
        service.deleteMessage(message.getId());
        return ResponseEntity.status(204).build();
    }
}
