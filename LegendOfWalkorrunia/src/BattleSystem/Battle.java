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
import Town.Dungeons.IDungeon;

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
    
    public Battle(IDungeon dungeon, Player player, IEnemy enemy) {
        this.dungeon = dungeon;
        this.player = player;
        this.enemy = enemy;
        playerHealth = player.getStats().hp;
        enemyHealth = enemy.getStats().hp;
    }
    
    public void attack() {
        if (playerHealth <= 0 || enemyHealth <= 0) return;
        AbstractAttack playerAttack = new BasicAttack(this);
        playerAttack.attack(player, enemy);
        //enemyHealth -= Math.max(1, player.getStats().attack - enemy.getStats().defense);
        if (enemyHealth <= 0) {
            dungeon.clearDungeon();
            return;
        }
        AbstractAttack enemyAttack = new BasicAttack(this);
        enemyAttack.attack(enemy, player);
        //playerHealth -= Math.max(1, enemy.getStats().attack - player.getStats().defense);
    }
    
    public void changeHealth(ICombatant combatant, int change) {
        if (combatant == player) playerHealth += change;
        else enemyHealth += change;
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
