/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleSystem;

import BattleSystem.Attacks.AbstractAttack;
import BattleSystem.Attacks.BasicAttack;
import Enemies.IEnemy;
import Player.Player;
import Player.Stats;
import Town.Dungeons.IDungeon;
import java.util.ArrayList;

/**
 *
 * @author Thomas
 */
public class Battle {
    private final IDungeon dungeon;
    private final Player player;
    private final IEnemy enemy;
    //We should probably rework this to be a map from ICombatants to integers
    private Integer playerHealth;
    private Integer enemyHealth;
    private final ArrayList<Buff> buffs = new ArrayList();
    
    public Battle(IDungeon dungeon, Player player, IEnemy enemy) {
        this.dungeon = dungeon;
        this.player = player;
        this.enemy = enemy;
        playerHealth = player.getStats().getStat(Stats.StatEnum.HP);
        enemyHealth = enemy.getStats().getStat(Stats.StatEnum.HP);
    }
    
    /**
    public void attack() {
        attack(new BasicAttack(this));
    }
    */
    
    public void turn(AbstractAttack attack) {
        if (playerHealth <= 0 || enemyHealth <= 0) return;
        attack.attack(this, player, enemy);
        if (enemyHealth <= 0) {
            dungeon.clearDungeon();
            return;
        }
        AbstractAttack enemyAttack = new BasicAttack(/*this*/);
        enemyAttack.attack(this, enemy, player);
        endTurn();
    }
    
    public void endTurn() {
        ArrayList thingsToRemove = new ArrayList();
        for (Buff buff : buffs) {
            buff.decrementTurnsRemaining();
            if (buff.turnsRemaining() < 1) {
                thingsToRemove.add(buff);
            }
        }
        buffs.removeAll(thingsToRemove);
    }
    
    public void changeHealth(ICombatant combatant, int change) {
        if (combatant == player) playerHealth += change;
        else enemyHealth += change;
    }
    
    public Integer getStat(ICombatant combatant, Stats.StatEnum stat) {
        Integer outputStat = combatant.getStats().getStat(stat);
        for (Buff buff : buffs) {
            if (buff.getCharacter() == combatant) {
                outputStat += buff.getChanges().getStat(stat);
            }
        }
        return outputStat;
    }
    
    public void addBuff(Buff buff) {
        buffs.add(buff);
    }
    
    public String getPlayerName() {
        return player.name;
    }
    
    public String getEnemyName() {
        return enemy.enemyName();
    }
    
    public Integer getPlayerHealth() {
        return playerHealth;
    }
    
    public Integer getEnemyHealth() {
        return enemyHealth;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public IEnemy getEnemy() {
        return enemy;
    }
        
}
