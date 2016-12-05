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
public class Royal implements IJob {
    final private GameEngine game;
    final Stats stats = new Stats();
    final List<AbstractAttack> attacks;
    
    public Royal(GameEngine game) {
        this.game = game;
        
        attacks = new ArrayList(4);
        attacks.add(new BasicAttack());
        attacks.add(new DoubleStrike());
        attacks.add(new Heal());
        attacks.add(new SwordDance());
    }
    
    @Override
    public String getJobName() {
        return "Royal";
    }

    @Override
    public String jobDescription() {
        return "Your basic starting job";
    }

    @Override
    public Stats getStats() {
        return stats;
    }
    
    @Override
    public boolean prereqsMet() {
        return true;
    }

    @Override
    public List<AbstractAttack> attacks() {
        return attacks;
    }
    
}
