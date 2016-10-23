/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player.Jobs;

import Player.Stats;

/**
 *
 * @author Thomas
 */
public class Royal implements IJob {
    final Stats stats = new Stats(0);
    
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
    
}
