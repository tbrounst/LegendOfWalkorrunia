/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import BattleSystem.Attacks.AbstractAttack;
import BattleSystem.ICombatant;
import GameEngine.GameEngine;
import Player.Jobs.IJob;
import Player.Jobs.Knight;
import Player.Jobs.Royal;
import java.util.HashMap;
import java.util.List;

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
    //private final Stats baseStats = new Stats();
    private Stats currentStats;
    
    public Player(GameEngine game, String name) {
        this.game = game;
        this.name = name;
        initializeJobs();
        changeJob("Royal");
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
    
    @Override
    public Stats getStats() {
        return currentStats;
    }
    
    private void computeStats() {
        Stats jobStats = job.getStats();
        currentStats = jobStats.computeStatsAtLevel(level);
        /**
        currentStats = new Stats((baseStats.getStat(Stats.StatEnum.HP) + jobStats.getStat(Stats.StatEnum.HP))*level, 
            (baseStats.getStat(Stats.StatEnum.ATTACK) + jobStats.getStat(Stats.StatEnum.ATTACK))*level,
            (baseStats.getStat(Stats.StatEnum.DEFENSE) + jobStats.getStat(Stats.StatEnum.DEFENSE))*level,
            (baseStats.getStat(Stats.StatEnum.MAGICATTACK) + jobStats.getStat(Stats.StatEnum.MAGICATTACK))*level,
            (baseStats.getStat(Stats.StatEnum.MAGICDEFENSE) + jobStats.getStat(Stats.StatEnum.MAGICDEFENSE))*level,
            (baseStats.getStat(Stats.StatEnum.SPEED) + jobStats.getStat(Stats.StatEnum.SPEED))*level);
            **/
    }
    
    public List<AbstractAttack> getAttacks() {
        return job.attacks();
    }
    
    private void initializeJobs() {
        smartAddToList(new Royal(game));
        smartAddToList(new Knight(game));
    }
    
    private void smartAddToList(IJob job) {
        jobs.put(job.getJobName(), job);
    }
    
}
