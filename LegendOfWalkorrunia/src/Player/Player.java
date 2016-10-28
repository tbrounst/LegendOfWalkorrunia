/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import BattleSystem.ICombatant;
import GameEngine.GameEngine;
import Player.Jobs.IJob;
import Player.Jobs.Knight;
import Player.Jobs.Royal;
import java.util.HashMap;

/**
 *
 * @author Thomas
 */
public class Player implements ICombatant{
    public final String name;
    private int level = 1;
    private IJob job;
    private final GameEngine game;
    private final HashMap<String, IJob> jobs = new HashMap();
    private final Stats baseStats = new Stats();
    private Stats currentStats = baseStats;
    
    public Player(GameEngine game, String name) {
        this.game = game;
        this.name = name;
        initializeJobs();
        changeJob("Royal");
        computeStats();
    }
    
    public int getLevel() {
        return level;
    }
    
    public void changeJob(String job) {
        changeJob(jobs.get(job));
    }
    
    public void changeJob(IJob job) {
        if(!job.prereqsMet()) return;
        this.job = job;
        computeStats();
    }
    
    public IJob getJob() {
        return job;
    }
    
    public Stats getStats() {
        return currentStats;
    }
    
    private void computeStats() {
        Stats jobStats = job.getStats();
        currentStats = new Stats((baseStats.hp + jobStats.hp)*level, 
            (baseStats.attack + jobStats.attack)*level,
            (baseStats.defense + jobStats.defense)*level,
            (baseStats.magicAttack + jobStats.magicAttack)*level,
            (baseStats.magicDefense + jobStats.magicDefense)*level,
            (baseStats.speed + jobStats.speed)*level);
    }
    
    private void initializeJobs() {
        smartAddToList(new Royal());
        smartAddToList(new Knight(game));
    }
    
    private void smartAddToList(IJob job) {
        jobs.put(job.getJobName(), job);
    }
    
}
