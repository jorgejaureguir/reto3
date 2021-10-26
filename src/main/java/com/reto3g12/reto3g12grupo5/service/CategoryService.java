/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;

import com.reto3g12.reto3g12grupo5.entity.Category;
import com.reto3g12.reto3g12grupo5.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    
    /**C
     * Nuevo Category
     */    
    public Category saveCategory(Category audience){
        return repository.save(audience);
    }
    /**R
     * Mostrar todos las categorias
     */
    public List<Category> getCategories(){
        return  repository.findAll();
    }
    
    /**U
     * Actualizar registros categorias
     */
    public Category updateCategory(Category category){
        Category existeCategory = repository.findById(category.getId()).orElse(null);
        existeCategory.setName(category.getName());
        existeCategory.setDescription(category.getDescription());
        repository.save(existeCategory);
        return existeCategory;        
    }
    /**
     * D
     * Eliminar Registro de la tabla Categoria
     * 
     */
    
    public String deleteCategory(int id){   
        repository.deleteById(id);
        return "Category Removido "+id;        
    }
}
