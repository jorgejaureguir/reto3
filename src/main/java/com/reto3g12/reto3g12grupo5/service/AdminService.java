/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;

import com.reto3g12.reto3g12grupo5.entity.Admin;
import com.reto3g12.reto3g12grupo5.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    
    /**C
     * Nuevo Admin
     */    
    public Admin saveAdmin(Admin admin){
        return repository.save(admin);
    }
    /**R
     * Mostrar todos los Admins
     */
    public List<Admin> getAdmins(){
        return  repository.findAll();
    }
    
    /**U
     * Actualizar registros Admins
     */
    public Admin updateAdmin(Admin admin){
        Admin existeAdmin = repository.findById(admin.getId()).orElse(null);
        existeAdmin.setName(admin.getName());
        existeAdmin.setEmail(admin.getEmail());
        existeAdmin.setPassword(admin.getPassword());
        repository.save(existeAdmin);
        return existeAdmin;
        
    }
    /**
     * D
     * Eliminar Registro de la tabla Admin
     * 
     */
    
    public String deleteAdmin(int id){   
        repository.deleteById(id);
        return "Admin Removido "+id;        
    }

}
