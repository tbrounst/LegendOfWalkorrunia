/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import BattleSystem.Attacks.AbstractAttack;
import BattleSystem.Attacks.BasicAttack;
import BattleSystem.Attacks.DefensiveHit;
import BattleSystem.Attacks.RecklessAttack;
import BattleSystem.Attacks.SuperDefense;
import GameEngine.GameEngine;
import Player.Stats;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class Knight implements IJob {
    final private GameEngine game;
    final Stats stats = new Stats(15, 12, 13, 5, 7, 8);
    final List<AbstractAttack> attacks;
    
    
    public Knight(GameEngine game) {
        this.game = game;
        
        attacks = new ArrayList(4);
        attacks.add(new BasicAttack());
        attacks.add(new DefensiveHit());
        attacks.add(new SuperDefense());
        attacks.add(new RecklessAttack());
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

    @Override
    public List<AbstractAttack> attacks() {
        return attacks;
    }
    
}
