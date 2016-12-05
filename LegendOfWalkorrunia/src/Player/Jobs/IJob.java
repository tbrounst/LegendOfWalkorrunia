/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import BattleSystem.Attacks.AbstractAttack;
import Player.Stats;
import java.util.List;

/**
 *
 * @author Thomas
 */
public interface IJob {
    
    public String getJobName();
    
    public String jobDescription();
    
    public Stats getStats();
    
    public boolean prereqsMet();
    
    public List<AbstractAttack> attacks();
    
}
