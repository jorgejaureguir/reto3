/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.service;


import com.reto3g12.reto3g12grupo5.entity.Score;
import com.reto3g12.reto3g12grupo5.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;
    
    /**C
     * Nuevo Score
     */    
    public Score saveScore(Score score){
        return repository.save(score);
    }
    /**R
     * Mostrar todos los Scores
     */
    public List<Score> getScores(){
        return  repository.findAll();
    }
    
    /**U
     * Actualizar registros Scores
     */
    public Score updateScore(Score score){
        Score existeScore = repository.findById(score.getIdScore()).orElse(null);
        existeScore.setScore(score.getScore());
        existeScore.setMessageScore(score.getMessageScore());
        repository.save(existeScore);
        return existeScore;
        
    }
    /**
     * D
     * Eliminar Registro de la tabla Score
     * 
     */
    
    public String deleteScore(int id){   
        repository.deleteById(id);
        return "Score Removido "+id;        
    }
}
