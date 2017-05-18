/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import BattleSystem.Attacks.AbstractAttack;
import GameEngine.GameEngine;
import Player.Stats;
import java.util.List;

/**
 *
 * @author Thomas
 */
public abstract class AbstractJob {
    protected final GameEngine game;
    protected String jobName;
    protected String jobDescription;
    protected Stats stats;
    protected List<AbstractAttack> attacks;
    
    public AbstractJob(GameEngine game) {
        this.game = game;
    }
    
    public String getJobName() {
        return jobName;
    }
    
    public String jobDescription() {
        return jobDescription;
    }
    
    public Stats getStats() {
        return stats;
    }
    
    public List<AbstractAttack> attacks() {
        return attacks;
    }
    
    abstract public boolean prereqsMet();
    
}
