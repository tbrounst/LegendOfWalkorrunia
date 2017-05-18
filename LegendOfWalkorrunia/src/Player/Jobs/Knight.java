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
public class Knight extends AbstractJob {
    String thisJobName = "Knight";
    String thisJobDescription = "Sword mage casts stab!";
    Stats thisStats = new Stats(15, 12, 13, 5, 7, 8);
    
    
    public Knight(GameEngine game) {
        super(game);
        
        super.jobName = thisJobName;
        super.jobDescription = thisJobDescription;
        super.stats = thisStats;
        
        super.attacks = new ArrayList(4);
        super.attacks.add(new BasicAttack());
        super.attacks.add(new DefensiveHit());
        super.attacks.add(new SuperDefense());
        super.attacks.add(new RecklessAttack());
    }
    
    @Override
    public boolean prereqsMet() {
        return game.getTown().buildingIsBuilt("Training Grounds");
    }
}
