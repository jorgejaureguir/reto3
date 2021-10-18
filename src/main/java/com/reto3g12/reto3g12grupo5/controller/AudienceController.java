/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.controller;

import com.reto3g12.reto3g12grupo5.entity.Audience;
import com.reto3g12.reto3g12grupo5.service.AudienceService;
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
@RequestMapping("/api/Audience")
public class AudienceController {
    @Autowired
    private AudienceService service;
    
    @GetMapping("/all")
    public List<Audience> findAllAudience(){
        return service.getAudiences();
    }
    
    @PostMapping("/save")
    public ResponseEntity addAudience(@RequestBody Audience audience ){
        service.saveAudience(audience);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateAudience(@RequestBody Audience audience){
        service.updateAudience(audience);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteAudience(@RequestBody Audience audience){
        service.deleteAudience(audience.getId());
        return ResponseEntity.status(204).build();
    }
}
