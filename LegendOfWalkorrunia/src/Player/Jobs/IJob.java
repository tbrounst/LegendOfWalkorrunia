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
public interface IJob {
    
    public String getJobName();
    
    public String jobDescription();
    
    public Stats getStats();
    
    public boolean prereqsMet();
    
}
