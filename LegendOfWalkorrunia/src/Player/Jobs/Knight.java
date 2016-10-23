/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import GameEngine.GameEngine;
import Player.Player;
import Player.Stats;
import Town.Buildings.IBuilding;

/**
 *
 * @author Thomas
 */
public class Knight implements IJob {
    GameEngine game;
    final Stats stats = new Stats(5, 2, 3, -5, -3, -2);
    
    public Knight(GameEngine game) {
        this.game = game;
    }
    
    @Override
    public String getJobName() {
        return "Knight";
    }

    @Override
    public String jobDescription() {
        return "Sword mage casts stab!";
    }
    
   @Override
   public Stats getStats() {
       return stats;
   }
   
   @Override
   public boolean prereqsMet() {
       return game.getJobPrereqs().knightPrereqsMet();
   }
    
}
