/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;


import com.reto3g12.reto3g12grupo5.entity.Audience;
import com.reto3g12.reto3g12grupo5.repository.AudienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class AudienceService {
    @Autowired
    private AudienceRepository repository;
    
    /**C
     * Nuevo Audience
     */    
    public Audience saveAudience(Audience audience){
        return repository.save(audience);
    }
    /**R
     * Mostrar todos los Audiences
     */
    public List<Audience> getAudiences(){
        return  repository.findAll();
    }
    
    /**U
     * Actualizar registros Audiences
     */
    public Audience updateAudience(Audience audience){
        Audience existeAudience = repository.findById(audience.getId()).orElse(null);
        existeAudience.setOwner(audience.getOwner());
        existeAudience.setCapacity(audience.getCapacity());
        existeAudience.setName(audience.getName());
        existeAudience.setDescription(audience.getDescription());
        repository.save(existeAudience);
        return existeAudience;
        
    }
    /**
     * D
     * Eliminar Registro de la tabla Audience
     * 
     */
    
    public String deleteAudience(int id){   
        repository.deleteById(id);
        return "Audience Removido "+id;        
    }

}
