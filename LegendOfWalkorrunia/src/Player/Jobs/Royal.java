/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import BattleSystem.Attacks.AbstractAttack;
import BattleSystem.Attacks.BasicAttack;
import BattleSystem.Attacks.DoubleStrike;
import BattleSystem.Attacks.Heal;
import BattleSystem.Attacks.SwordDance;
import GameEngine.GameEngine;
import Player.Stats;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class Royal extends AbstractJob {
    String thisJobName = "Royal";
    String thisJobDescription = "Your basic starting job";
    Stats thisStats = new Stats(10, 10, 10, 10, 10, 10);
    
    public Royal(GameEngine game) {
        super(game);
        
        super.jobName = thisJobName;
        super.jobDescription = thisJobDescription;
        super.stats = thisStats;
        
        attacks = new ArrayList(4);
        attacks.add(new BasicAttack());
        attacks.add(new DoubleStrike());
        attacks.add(new Heal());
        attacks.add(new SwordDance());
    }
    
    @Override
    public boolean prereqsMet() {
        return true;
    }
    
}
