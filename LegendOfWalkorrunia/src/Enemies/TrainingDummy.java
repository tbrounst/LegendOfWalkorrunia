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
public class TrainingDummy implements IEnemy {
    private final Stats stats;
    private final String name = "TrainingDummy";
    private final Integer level = 1;

    public TrainingDummy() {
        this(new Stats(100, 10, 8, 10, 10, 10));
    }
    
    public TrainingDummy(Stats stats) {
        this.stats = stats;
    }
    
    @Override
    public String enemyName() {
        return name;
    }

    @Override
    public Stats getStats() {
        return stats.computeStatsAtLevel(level);
    }
}
