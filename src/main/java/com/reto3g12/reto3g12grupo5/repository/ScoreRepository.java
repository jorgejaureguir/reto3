/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.repository;

import com.reto3g12.reto3g12grupo5.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jorge
 */
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    
}
