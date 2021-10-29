/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3g12.reto3g12grupo5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge
 */
@Data
@AllArgsConstructor
/**@NoArgsConstructor*/
public class CountClients {
    
    private Long total;
    private Client client;
}
