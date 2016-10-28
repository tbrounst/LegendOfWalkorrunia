/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemies;

import Player.Stats;

/**
 *
 * @author Thomas
 */
public class Orc implements IEnemy {
    private final Stats stats = new Stats(9, 13, 11, 10, 10, 10);
    private final String name = "Orc";
    
    public Orc() {
    }

    @Override
    public String enemyName() {
        return name;
    }

    @Override
    public Stats getStats() {
        return stats;
    }
    
}
